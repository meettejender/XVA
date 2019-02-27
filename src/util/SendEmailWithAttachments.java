package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class SendEmailWithAttachments {


    private static final String SMTP_SERVER = "192.168.17.8";
    private static final int SMTP_PORT = 25;
    private static final String CONFIG_MAILID = "";
    private static final String CONFIG_PWD = "";
    private final static String from = "XVARegressions@numerix.com"; 
    //private final String to = "tjuturu@csc.com,rkunta@csc.com,sphanim@csc.com,araza6@csc.com";
    private final String to = "siddiqui@numerix.com,dbrandow@numerix.com,nshalmiyeva@numerix.com,tzhou@numerix.com,dspector@numerix.com,rellison@numerix.com,tjuturu@csc.com,rkunta@csc.com,sphanim@csc.com,araza6@csc.com";
    private String subject = "Test Email";
    private String messageContent = "Test Message";
    public static String zipFile = null;
    
    public String serverURL;
    public String serverIP;
	public String xvaBuildType;
	public String xvaBuildOrigin;
	public String xvaBuildVersion;
	public String database;
    public String tcBuildName;
	public String tcBuildNumber;
	public String tcBuildID;
	public String tcProjectID;
	public String tcTestRunURL;
	public String browser = "Chrome";
	public String serverOS;
	public StringBuilder emailBody = new StringBuilder();
	
	public String total;
	public String pass;
	public String fail;
	public String skip;
	public String startTime;
	public String endTime;
	public String totalTime;
	public String testResultsLink;
	
	public final static char CR  = (char) 0x0D;
	public final static char LF  = (char) 0x0A; 
	//public final static String CRLF  = "" + CR + LF;     // "" forces conversion to string
	public final static String CRLF  = "\n";

	
    public SendEmailWithAttachments() {
		//GeneralUtil.configureLog4j("Email Notification");
		//GeneralUtil.logger("Email Notification");
    }
    
    public SendEmailWithAttachments(String[] args) throws IOException {
		serverURL = args[0];
    	xvaBuildType = args[1];
    	xvaBuildOrigin = args[2];
		xvaBuildVersion = args[3];
		database = args[4];
		tcBuildID = args[5];
		tcBuildNumber = args[6];
		tcBuildName = args[7];
		tcProjectID = args[8];
		serverIP = serverURL.substring(serverURL.indexOf('/')+1, serverURL.lastIndexOf(':'));
		tcTestRunURL =  String.format("http://tcsvr/viewLog.html?buildId=%s&tab=artifacts", tcBuildID);
    	/*xvaBuildType = "Windows";
		xvaBuildVersion = "4567";
		database = "SQL";
		tcBuildNumber = "123";
		tcBuildID = "2818025";*/
		if (xvaBuildType.equalsIgnoreCase("windows"))
		{
			serverOS = "Windows Server 2016 Standard";
			//serverIP = "192.168.19.84";
			//serverURL = "http://192.168.19.84:18080";
			//if(database.equalsIgnoreCase("sql"))
			//{
				//tcBuildName = "GUI Tests-64: Windows_SQL";
				//tcTestRunURL =  String.format("http://tcsvr/viewLog.html?buildId=%s&buildTypeId=QAE_XVA_GuiTests64Windows&tab=artifacts", tcBuildID);
			//}
			//else
				//if(database.equalsIgnoreCase("mongo"))
				//{
					//tcBuildName = "GUI Tests-64: Windows_Mongo";
					//tcTestRunURL =  String.format("http://tcsvr/viewLog.html?buildId=%s&buildTypeId=QAE_XVA_GuiTests64WindowsMongo&tab=artifacts", tcBuildID);
				//}
		}
		else if (xvaBuildType.equalsIgnoreCase("linux"))
		{
			serverOS = "CentOS Linux release 7.2.1511";
			//serverIP = "192.168.19.188";
			//serverURL = "http://192.168.19.188:18080";
			//if(database.equalsIgnoreCase("sql"))
			//{
				//tcBuildName = "GUI Tests: Linux_SQL";
				//tcTestRunURL =  String.format("http://tcsvr/viewLog.html?buildId=%s&buildTypeId=QAE_XVA_GuiTestsLinuxSql&tab=artifacts", tcBuildID);
			//}
			//else
				//if(database.equalsIgnoreCase("mongo"))
			//{
				//tcBuildName = "GUI Tests: Linux_Mongo";
				//tcTestRunURL =  String.format("http://tcsvr/viewLog.html?buildId=%s&buildTypeId=QAE_XVA_GuiTestsLinuxMongo&tab=artifacts", tcBuildID);
			//}
		}
		testResultsLink = "<\\\\bisector5\\nas\\XVAregression\\" + String.format("GUI Tests %s_%s", xvaBuildType, database) + "\\" + GeneralUtil.baseResultsFolder + ">";
		
		pass = System.getProperty("TestsPassed");
		fail = System.getProperty("TestsFailed");
		skip = System.getProperty("TestsSkipped");
		total = System.getProperty("TotalTests");
		startTime = System.getProperty("StartTime");
		endTime = System.getProperty("EndTime");
		totalTime = System.getProperty("TotalTime");
		
		System.out.println("XVA BuildType: " + xvaBuildType);
		System.out.println("XVA BuildVersion: " + xvaBuildVersion);
		System.out.println("XVA BuildOrigin: " + xvaBuildOrigin);
		System.out.println("XVA Database: " + database);
		System.out.println("buildNumber: " + tcBuildNumber);
		System.out.println("buildID: " + tcBuildID);
		System.out.println("TeamCity Test Name: " + tcBuildName);
		System.out.println("TeamCity Test Artifacts: " + tcTestRunURL);
		System.out.println("serverURL: " + serverURL);
		
		emailBody.append("Test Results...."); 
		emailBody.append("\n");
		emailBody.append("Total Tests: "); 
		emailBody.append(total);
		emailBody.append(CRLF);
		emailBody.append("Passed: "); 
		emailBody.append(pass);
		emailBody.append(CRLF);
		emailBody.append("Failed: "); 
		emailBody.append(fail);
		emailBody.append(CRLF);
		emailBody.append("Skipped: "); 
		emailBody.append(skip);
		emailBody.append(CRLF);
		emailBody.append("Start Time: "); 
		emailBody.append(startTime);
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append("End Time: "); 
		emailBody.append(endTime);
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append("Execution Duration (mm:ss): "); 
		emailBody.append(totalTime);
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append("Test Results available at: "); 
		emailBody.append(testResultsLink);
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append(CRLF);
		
		emailBody.append("Team City Info...."); 
		emailBody.append("\n");
		emailBody.append("TeamCity Test Name: "); 
		emailBody.append(tcBuildName);
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append("TeamCity Build Number: "); 
		emailBody.append(tcBuildNumber);
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append("TeamCity Test Artifacts: "); 
		emailBody.append(tcTestRunURL);
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append(CRLF);
		
		emailBody.append("Build Info...."); 
		emailBody.append("\n");
		emailBody.append("Build Type: "); 
		emailBody.append(xvaBuildType);
		emailBody.append(CRLF);
		emailBody.append("Build Origin: "); 
		emailBody.append(xvaBuildOrigin);
		emailBody.append(CRLF);
		emailBody.append("Build Version: "); 
		emailBody.append(xvaBuildVersion);
		emailBody.append(CRLF);
		emailBody.append(CRLF);

		emailBody.append("Server & Other Info...."); 
		emailBody.append("\n");
		emailBody.append("URL: "); 
		emailBody.append(serverURL);
		emailBody.append(CRLF);
		emailBody.append("Server IP: "); 
		emailBody.append(serverIP);
		emailBody.append(CRLF);
		emailBody.append("Server OS: "); 
		emailBody.append(serverOS);
		emailBody.append(CRLF);
		emailBody.append("Database: "); 
		emailBody.append(database);
		emailBody.append(CRLF);
		emailBody.append("Browser: "); 
		emailBody.append(browser);
		emailBody.append(CRLF);
		emailBody.append(CRLF);
		
		emailBody.append("Understanding attached Report.zip....");
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append("1. The Selenium test reports are attached here. Open \"emailable-report.html\"");
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append("2. Navigate through the links to find the test case and its test steps with description under each test suite");
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append("3. For failures, test case link will lead to exact test step failed with relevant exception and call stack");
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append(CRLF);

		emailBody.append("Understanding Full Execution Results....");
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append("1. In addition to selenium reports, full execution results are bundled with logs, screenshots and downloads"); 
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append("2. Full execution results are available on the shared path link provided above"); 
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append("3. Alternatively, click on \"TeamCity Test Artifacts\" link above to view full execution results");
		emailBody.append("   ");
		emailBody.append(CRLF);
		emailBody.append("4. Once on the Teamcity page, click on \"Emailable Report\" tab and \"Extent Report\" tab for selenium results"); 
		emailBody.append("   ");
		emailBody.append(CRLF);

		//[TeamCity, SUCCESSFUL] Build XVA::GUI Tests-64: Windows_Mongo #76
		//subject = tcBuildName;
		String status = Integer.parseInt(fail) > 0 ? "FAILED" : "SUCCESSFUL";
		subject = String.format("[TeamCity, %s] Build %s::%s #%s", status, tcProjectID, tcBuildName, tcBuildNumber);
		messageContent = emailBody.toString();
    }
    
	public void notifyResults() {

		// Create JSON Report with Test Run details
		try {
			CreateJSONReport();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		// Copy results to Numerix Shared location '//bisector5/nas/XVAregression'
		String resultsFolder = GeneralUtil.userDirectory + "\\ExecutionResults\\" + GeneralUtil.baseResultsFolder;
		try {
			String dirCopySource = resultsFolder;
			File srcDir = new File(dirCopySource);
			String dirCopyDestination = "\\\\bisector5\\nas\\XVAregression\\"
					+ String.format("GUI Tests %s_%s", xvaBuildType, database) + "\\" + GeneralUtil.baseResultsFolder;
			System.out.println("Directory Copy - Source" + dirCopySource);
			System.out.println("Directory Copy - Destination" + dirCopyDestination);
			File destDir = new File(dirCopyDestination);
			//if (!destDir.exists())
				//destDir.mkdirs();

			FileUtils.copyDirectory(srcDir, destDir);
			System.out.println("Results folder copied Successfully to shared network drive!!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Zip only the reports folder
		try {
			String zipSource = resultsFolder + "\\Reports";
			String zipDestination = resultsFolder + "\\Report.zip";
			System.out.println("Zip - Source" + zipSource);
			System.out.println("Zip - Destination" + zipDestination);
			zipFolder(zipSource, zipDestination);
			zipFile = zipDestination;
			System.out.println("Compressed reports folder Successfully!!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// send email notification to stake holders and attach the reports folder
		try {
			sendEmail();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
    public void CreateJSONReport() throws IOException
	{
		try {
			ObjectMapper mapper = new ObjectMapper();
			ObjectNode objectNode = mapper.createObjectNode();
			ObjectNode nodeTestRun = objectNode.putObject("TestRun");
			nodeTestRun.put("Product", "Oneview XVA");
			nodeTestRun.put("Version", "Trunk");
			nodeTestRun.put("Test Run Name", "XVA Regression");
			nodeTestRun.putObject("Test Run Type").put("type", "Financial").put("subtype", "null");
			nodeTestRun.putObject("Variant").put("OS", xvaBuildType).put("Result DB", database);
			nodeTestRun.putObject("Build").put("Type", xvaBuildType).put("Origin", xvaBuildOrigin).put("Version", xvaBuildVersion);
			nodeTestRun.putObject("Team City").put("Test Name", tcBuildName).put("Test Run Number", tcBuildNumber)
					.put("Test Artifact Link", tcTestRunURL);
			nodeTestRun.putObject("QA Server").put("Server IP", serverIP).put("Server OS", serverOS)
					.put("Application URL", serverURL);
			nodeTestRun.put("Browser", "Chrome");
			nodeTestRun.put("StartTime", startTime);
			nodeTestRun.put("EndTime", endTime);
			nodeTestRun.put("TotalTime", totalTime);
			ObjectNode nodeTestResults = nodeTestRun.putObject("Test Results");
			String strObjectNode = System.getProperty("TestResults");
			ObjectNode testResults = (ObjectNode) mapper.readTree(strObjectNode);
			testResultsLink = "file://///bisector5/nas/XVAregression/"
					+ String.format("GUI Tests %s_%s", xvaBuildType, database) + "/" + GeneralUtil.baseResultsFolder;
			testResultsLink = testResultsLink.replaceAll(" ", "%20");
			testResults.putObject("Test Results Links").put("Test Results Folder Location", testResultsLink);
			nodeTestResults.setAll(testResults);
			//System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode));
			FileWriter file = new FileWriter(GeneralUtil.testOutputDirectory + "/report.json");
			file.write(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objectNode));
			file.close();
			System.out.println("report.json created and saved to file Successfully!!");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
    
    static public void zipFolder(String srcFolder, String destZipFile) throws Exception {
        ZipOutputStream zip = null;
        FileOutputStream fileWriter = null;

        fileWriter = new FileOutputStream(destZipFile);
        zip = new ZipOutputStream(fileWriter);

        addFolderToZip("", srcFolder, zip);
        zip.flush();
        zip.close();
      }

      static private void addFileToZip(String path, String srcFile, ZipOutputStream zip)
          throws Exception {

        File folder = new File(srcFile);
        if (folder.isDirectory()) {
          addFolderToZip(path, srcFile, zip);
        } else {
          byte[] buf = new byte[1024];
          int len;
          FileInputStream in = new FileInputStream(srcFile);
          zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
          while ((len = in.read(buf)) > 0) {
            zip.write(buf, 0, len);
          }
        }
      }

      static private void addFolderToZip(String path, String srcFolder, ZipOutputStream zip)
          throws Exception {
        File folder = new File(srcFolder);

        for (String fileName : folder.list()) {
          if (path.equals("")) {
            addFileToZip(folder.getName(), srcFolder + "/" + fileName, zip);
          } else {
            addFileToZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
          }
        }
      }

    public void sendEmail() throws IOException {
        final Session session = Session.getInstance(this.getEmailProperties(), new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(CONFIG_MAILID, CONFIG_PWD);
            }

        });
        
        sendAttachmentEmail(session, to, subject, messageContent);
    }

    public Properties getEmailProperties() {
        final Properties config = new Properties();
        config.put("mail.transport.protocol", "smtp");
        config.put("mail.smtp.starttls.enable", "true");
        config.put("mail.smtp.host", SMTP_SERVER);
        config.put("mail.smtp.port", SMTP_PORT);
        return config;
    }
    
    public static void sendAttachmentEmail(Session session, String toEmail, String subject, String messageContent){
    	try{
             MimeMessage msg = new MimeMessage(session);
             msg.addHeader("Content-type", "text/HTML; charset=UTF-8");
    	     msg.addHeader("format", "flowed");
    	     msg.addHeader("Content-Transfer-Encoding", "8bit");
    	      
    	     msg.setFrom(new InternetAddress(from));

    	     msg.setReplyTo(InternetAddress.parse(from, false));

    	     msg.setSubject(subject, "UTF-8");

    	     msg.setSentDate(new Date());

    	     msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail, false));
    	      
             // Create the message body part
             BodyPart messageBodyPart = new MimeBodyPart();

             // Fill the message
             messageBodyPart.setText(messageContent);
             
             // Create a multipart message for attachment
             Multipart multipart = new MimeMultipart();

             // Set text message part
             multipart.addBodyPart(messageBodyPart);

             // Second part is attachment
             messageBodyPart = new MimeBodyPart();

             DataSource source = new FileDataSource(zipFile);
             messageBodyPart.setDataHandler(new DataHandler(source));
             messageBodyPart.setFileName("Report.zip");
             multipart.addBodyPart(messageBodyPart);

             // Send the complete message parts
             msg.setContent(multipart);

             // Send message
             Transport.send(msg);
             System.out.println("EMail Sent Successfully with attachment!!");
          }catch (MessagingException e) {
             e.printStackTrace();
          } catch (Exception e) {
    		 e.printStackTrace();
    	}
    }
}