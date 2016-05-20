CREATE TABLE IF NOT EXISTS ops
(op_id BIGINT AUTO_INCREMENT,
 op_type VARCHAR(10) NOT NULL,     -- session/hit/event/identify/start/stop
 site_id VARCHAR(256) NOT NULL,
 user_id VARCHAR(256) NOT NULL,
 session_id VARCHAR(50) NOT NULL,
 hash_code VARCHAR(50) NOT NULL,
 channel VARCHAR(20) NULL,         -- mobile, web, api, tablet
 page VARCHAR(500) NULL,           -- page for web, screen for mobile
 event VARCHAR(500) NULL,          -- event key
 created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
 PRIMARY KEY (op_id),
 UNIQUE KEY user_session_hash (user_id, session_id, hash_code),
 FOREIGN KEY (user_id) REFERENCES users(user_id) ON UPDATE CASCADE,
 FOREIGN KEY (session_id) REFERENCES sessions(session_id) ON DELETE CASCADE,
 FOREIGN KEY (site_id) REFERENCES sites(site_id) ON DELETE CASCADE);
