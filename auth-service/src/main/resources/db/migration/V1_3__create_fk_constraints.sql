-- Foreign key mapping user ID to profile
ALTER TABLE profiles
ADD CONSTRAINT fk_user
FOREIGN KEY (user_id) REFERENCES users(id);
