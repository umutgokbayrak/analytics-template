CREATE TABLE IF NOT EXISTS network_context
(id BIGINT AUTO_INCREMENT,
 op_id BIGINT NOT NULL,
 op_type VARCHAR(10) NOT NULL,
 site_id VARCHAR(256) NOT NULL,
 user_id VARCHAR(256) NOT NULL,
 session_id VARCHAR(50) NOT NULL,
 page VARCHAR(500) NULL,
 event VARCHAR(500) NULL,
 network_carrier VARCHAR(100) NULL,
 network_isp VARCHAR(150) NULL,           -- location'dan buraya tasindi
 network_bluetooth SMALLINT DEFAULT 0,    -- 0/1
 network_cellular SMALLINT DEFAULT 0,     -- 0/1
 network_wifi SMALLINT DEFAULT 0,         -- 0/1
 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (id),
 FOREIGN KEY (user_id) REFERENCES users(user_id) ON UPDATE CASCADE,
 FOREIGN KEY (session_id) REFERENCES sessions(session_id) ON DELETE CASCADE,
 FOREIGN KEY (site_id) REFERENCES sites(site_id) ON DELETE CASCADE);
