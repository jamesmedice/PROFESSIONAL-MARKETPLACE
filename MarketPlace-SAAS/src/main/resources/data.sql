
INSERT INTO oauth_client_details (client_id,
                                  client_secret,
                                  scope,
                                  authorized_grant_types,
                                  web_server_redirect_uri,
                                  authorities,
                                  access_token_validity,
                                  refresh_token_validity,
                                  additional_information,
                                  autoapprove)
     VALUES ('clientIdPassword',
             'secret',
             'foo,read,write',
             'password,authorization_code,refresh_token',
             NULL,
             NULL,
             36000,
             36000,
             NULL,
             TRUE);

INSERT INTO oauth_client_details (client_id,
                                  client_secret,
                                  scope,
                                  authorized_grant_types,
                                  web_server_redirect_uri,
                                  authorities,
                                  access_token_validity,
                                  refresh_token_validity,
                                  additional_information,
                                  autoapprove)
     VALUES ('userClientId',
             'secret',
             'read,write,foo,bar',
             'implicit',
             NULL,
             NULL,
             36000,
             36000,
             NULL,
             FALSE);

INSERT INTO oauth_client_details (client_id,
                                  client_secret,
                                  scope,
                                  authorized_grant_types,
                                  web_server_redirect_uri,
                                  authorities,
                                  access_token_validity,
                                  refresh_token_validity,
                                  additional_information,
                                  autoapprove)
     VALUES ('primeClientIdPassword',
             'secret',
             'bar,read,write',
             'password,authorization_code,refresh_token',
             NULL,
             NULL,
             36000,
             36000,
             NULL,
             TRUE);
              alter
              
              
INSERT INTO auth_details
        VALUES (
                  'james',
                  '$2a$11$gxpnezmYfNJRYnw/EpIK5Oe08TlwZDmcmUeKkrGcSGGHXvWaxUwQ2');

INSERT INTO auth_details
        VALUES (
                  'tiago',
                  '$2a$11$gxpnezmYfNJRYnw/EpIK5Oe08TlwZDmcmUeKkrGcSGGHXvWaxUwT2');


INSERT INTO oauth_client_details (client_id,
                                  resource_ids,
                                  client_secret,
                                  scope,
                                  authorized_grant_types,
                                  authorities,
                                  access_token_validity,
                                  refresh_token_validity)
     VALUES ('james-client-id',
             'rest_api',
             '12345',
             'trust,read,write',
             'password,authorization_code,refresh_token,implicit',
             'ROLE_USER',
             '5',
             '1000');


INSERT INTO oauth_client_details (client_id,
                                  resource_ids,
                                  client_secret,
                                  scope,
                                  authorized_grant_types,
                                  authorities,
                                  access_token_validity,
                                  refresh_token_validity)
     VALUES ('tiago-client-id',
             'rest_api',
             '12345',
             'trust,read,write',
             'password,authorization_code,refresh_token,implicit',
             'ROLE_USER',
             '5',
             '1000');