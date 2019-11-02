package CT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


@RestController
public class MailController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    private String sender="1551729019@qq.com";

    private String receiver="741493258@qq.com";

    @Autowired
    private JavaMailSender javaMailSender;

    @Scheduled(cron = "*/50 * * * * ?")
    @RequestMapping("/sendMail")
    public String sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(sender);
        message.setTo(receiver);
        message.setSubject("尊敬的段思宇你好");
        message.setText("感谢你应聘随行付公司，但是你的个人能力太有限，我们不打算录用你！");
        try {
            javaMailSender.send(message);
            logger.info("邮件已经发送。");
        } catch (Exception e) {
            logger.error("发送邮件时发生异常！", e);
        }
        return "success";
    }
}