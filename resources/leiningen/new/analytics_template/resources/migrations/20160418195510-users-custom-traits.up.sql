CREATE TABLE IF NOT EXISTS users_custom_traits
(id BIGINT AUTO_INCREMENT,
 site_id VARCHAR(256) NOT NULL,
 user_id VARCHAR(256) NOT NULL,
 trait_name VARCHAR(50) NOT NULL,
 trait_value VARCHAR(150) NOT NULL,
 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 updated_at TIMESTAMP NULL,
 PRIMARY KEY (id),
 UNIQUE KEY user_trait_name (site_id, user_id, trait_name),
 FOREIGN KEY (user_id) REFERENCES users(user_id) ON UPDATE CASCADE,
 FOREIGN KEY (site_id) REFERENCES sites(site_id) ON DELETE CASCADE);
