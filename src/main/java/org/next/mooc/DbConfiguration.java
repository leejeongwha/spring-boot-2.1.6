package org.next.mooc;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.nhncorp.lucy.nclavis.NClavisAuthInfo;
import com.nhncorp.lucy.nclavis.https.NClavisENVProfile;
import com.nhncorp.lucy.nclavis.https.client.NClavisClient;
import com.nhncorp.lucy.nclavis.https.message.NClavisHttpsRequest;
import com.nhncorp.lucy.nclavis.https.message.NClavisHttpsResponse;
import com.nhncorp.lucy.nclavis.model.DBConnectionInfo;

@Configuration
public class DbConfiguration {
	@Value("${nclavis.db-connection-info.request-hash-key}")
	private String symkey1;
	
	@Bean
	public DataSource datasource() throws Exception {
		NClavisAuthInfo authInfo = new NClavisAuthInfo()
				.buildAuthInfoFromDefaultSystemTrustStore(NClavisENVProfile.DEV);
		NClavisHttpsRequest request = new NClavisHttpsRequest("symkey1", symkey1);

		NClavisClient client = NClavisClient.getInstance(authInfo).initialize();
		NClavisHttpsResponse response = client.execute(request);

		if (response.success()) {
			DBConnectionInfo dbconnInfo = (DBConnectionInfo) response.getFirstSecureData();

			DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
	        dataSourceBuilder.url(dbconnInfo.getDbconnUrl());
	        dataSourceBuilder.username(dbconnInfo.getDbconnUsrNm());
	        dataSourceBuilder.password(dbconnInfo.getDbconnPwd());
	        dataSourceBuilder.driverClassName("cubrid.jdbc.driver.CUBRIDDriver");
	        return (DataSource) dataSourceBuilder.build();
		} else {
			return null;
		}
	}
}
