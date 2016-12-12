CREATE TABLE saticilar (sat_id BIGINT AUTO_INCREMENT NOT NULL, �S�M VARCHAR(255), SOY�S�M VARCHAR(255), PRIMARY KEY (sat_id))
CREATE TABLE siparis (sip_id BIGINT AUTO_INCREMENT NOT NULL, MUSAD� VARCHAR(255), TUTAR DOUBLE, sat_id BIGINT, PRIMARY KEY (sip_id))
ALTER TABLE siparis ADD CONSTRAINT FK_siparis_sat_id FOREIGN KEY (sat_id) REFERENCES saticilar (sat_id)
