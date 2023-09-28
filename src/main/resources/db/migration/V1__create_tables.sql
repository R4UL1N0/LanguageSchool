
CREATE TABLE IF NOT EXISTS teacher (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birthday DATE NOT NULL,
    street VARCHAR(200),
    city VARCHAR(100),
    country VARCHAR(100),
    zipcode VARCHAR(20),
    active BOOLEAN,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

CREATE TABLE IF NOT EXISTS classroom (
    id SERIAL PRIMARY KEY,
    class_code VARCHAR(10) NOT NULL,
    start_date DATE,
    end_date DATE,
    class_level VARCHAR(255),
    class_lang VARCHAR(255),
    teacher_id BIGINT,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE classroom
ADD CONSTRAINT fk_teacher_id
FOREIGN KEY (teacher_id)
REFERENCES teacher(id);

CREATE TABLE IF NOT EXISTS student (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    birthday DATE NOT NULL,
    classroom_id BIGINT,
    street VARCHAR(200),
    city VARCHAR(100),
    country VARCHAR(100),
    zipcode VARCHAR(20),
    active BOOLEAN,
    created_at TIMESTAMP,
    updated_at TIMESTAMP
);

ALTER TABLE student
ADD CONSTRAINT fk_classroom_id
FOREIGN KEY (classroom_id)
REFERENCES classroom(id);