CREATE TABLE IF NOT EXISTS subject(
    id BIGINT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    subject_name VARCHAR(100) NOT NULL,
    marks_obtained DOUBLE PRECISION NULL,
    created TIMESTAMP NULL,
    modified TIMESTAMP NULL,
    student_id BIGINT NULL ,
    CONSTRAINT fk_subject_student_id
    FOREIGN KEY (student_id)
    REFERENCES student (id)
);
