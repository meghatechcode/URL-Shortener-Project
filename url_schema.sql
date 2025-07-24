
CREATE TABLE url_mapping (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    original_url VARCHAR(2083) NOT NULL,
    short_code VARCHAR(255) UNIQUE,
    created_at DATETIME,
    access_count INT DEFAULT 0
);
