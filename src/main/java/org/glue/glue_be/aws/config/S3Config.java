package org.glue.glue_be.aws.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.AwsCredentialsProvider;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;


@Configuration
public class S3Config {
	@Value("${cloud.aws.credentials.access-key}")
	private String accessKey;

	@Value("${cloud.aws.credentials.secret-key}")
	private String secretKey;

	@Value("${cloud.aws.region.static}")
	private Region region;


	// 우리 서비스 AWS 인증 객체
	@Bean
	public S3Presigner s3Presigner() {
		AwsCredentialsProvider credentialsProvider = StaticCredentialsProvider.create(
			AwsBasicCredentials.create(accessKey, secretKey));

		return S3Presigner.builder()
			.region(region)
			.credentialsProvider(credentialsProvider)
			.build();
	}

}
