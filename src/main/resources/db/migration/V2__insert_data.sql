INSERT INTO teacher (name, last_name, birthday, street, city, country, zipcode, active, created_at, updated_at)
VALUES
    ('John', 'Doe', '1990-05-15', '123 Main St', 'New York', 'USA', '10001', true, NOW(), NOW()),
    ('Jane', 'Smith', '1985-08-20', '456 Elm St', 'Los Angeles', 'USA', '90001', true, NOW(), NOW()),
    ('Robert', 'Johnson', '1980-12-10', '789 Oak Ave', 'Chicago', 'USA', '60601', true, NOW(), NOW()),
    ('Maria', 'Garcia', '1975-03-25', '789 Oak Ave', 'Chicago', 'USA', '60601', true, NOW(), NOW());

INSERT INTO classroom (class_code, start_date, end_date, class_level, class_lang, teacher_id, created_at, updated_at)
VALUES
    ('CS101', '2023-01-10', '2023-05-20', 'A1', 'ENGLISH', 1, NOW(), NOW()),
    ('MATH201', '2023-01-15', '2023-05-25', 'A2', 'ENGLISH', 2, NOW(), NOW()),
    ('ENG101', '2023-01-20', '2023-05-30', 'B1', 'ENGLISH', 1, NOW(), NOW()),
    ('HIST101', '2023-01-25', '2023-05-15', 'B2', 'ENGLISH', 3, NOW(), NOW());

INSERT INTO student (name, last_name, birthday, classroom_id, street, city, country, zipcode, active, created_at, updated_at)
VALUES
    ('Alice', 'Smith', '2000-03-15', 1, '123 Elm St', 'Los Angeles', 'USA', '90001', true, NOW(), NOW()),
    ('Bob', 'Johnson', '2001-05-20', 2, '456 Oak Ave', 'New York', 'USA', '10001', true, NOW(), NOW()),
    ('Charlie', 'Garcia', '2002-07-25', 3, '789 Main St', 'Chicago', 'USA', '60601', true, NOW(), NOW()),
    ('David', 'Lee', '2003-09-30', 1, '987 Maple Rd', 'San Francisco', 'USA', '94101', true, NOW(), NOW());