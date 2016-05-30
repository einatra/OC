BEGIN TRANSACTION;
CREATE TABLE `words` (
	`character`	TEXT,
	`pinyin`	TEXT,
	`meaning`	TEXT
);
INSERT INTO `words` VALUES ('我','wǒ','I / me / my');
INSERT INTO `words` VALUES ('你','nǐ','you');
INSERT INTO `words` VALUES ('们','men','plural marker for pronouns, and nouns referring to individuals');
INSERT INTO `words` VALUES ('是','shì','is / are / am / yes / to be');
INSERT INTO `words` VALUES ('好','hǎo','good / well / proper / good to / easy to / very / so');
CREATE TABLE `android_metadata` (
	`local`	TEXT DEFAULT 'en_US'
);
COMMIT;
