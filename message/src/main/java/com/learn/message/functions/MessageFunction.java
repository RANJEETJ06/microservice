package com.learn.message.functions;

import com.learn.message.dto.AccountMsgDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class MessageFunction {
    public final Logger logger=LoggerFactory.getLogger(MessageFunction.class);

    @Bean
    public Function<AccountMsgDto,AccountMsgDto> email(){
        return accountMsgDto -> {
            logger.info("sending email with the field details:{}", accountMsgDto.toString());
            return accountMsgDto;
        };
    }

    @Bean
    public Function<AccountMsgDto,Long> sms(){
        return accountMsgDto -> {
            logger.info("sending sms with the field details:{}", accountMsgDto.toString());
            return accountMsgDto.accountNumber();
        };
    }
}
