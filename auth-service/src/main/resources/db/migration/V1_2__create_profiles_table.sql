-- Stores user profiles
CREATE TABLE profiles (
    id SERIAL PRIMARY KEY,
    date_of_birth DATE,
    height FLOAT NOT NULL,
    weight FLOAT NOT NULL,
    activity VARCHAR(1) NOT NULL,
    gender VARCHAR(1) NOT NULL,

    user_id BIGINT UNIQUE
);