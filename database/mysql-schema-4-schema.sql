create table if not exists tig_users (
	uid bigint unsigned NOT NULL auto_increment,

	-- Jabber User ID
	user_id varchar(2049) NOT NULL,
	-- UserID SHA1 hash to prevent duplicate user_ids
	sha1_user_id char(128) NOT NULL,
	-- User password encrypted or not
	user_pw varchar(255) default NULL,
	-- Time the account has been created
	acc_create_time timestamp DEFAULT CURRENT_TIMESTAMP,
	-- Time of the last user login
	last_login timestamp DEFAULT CURRENT_TIMESTAMP,
	-- Time of the last user logout
	last_logout timestamp DEFAULT CURRENT_TIMESTAMP,
	-- User online status, if > 0 then user is online, the value
	-- indicates the number of user connections.
	-- It is incremented on each user login and decremented on each
	-- user logout.
	online_status int default 0,
	-- Number of failed login attempts
	failed_logins int default 0,
	-- User status, whether the account is active or disabled
	-- >0 - account active, 0 - account disabled
	account_status int default 1,

	primary key (uid),
	unique key sha1_user_id (sha1_user_id),
	key user_pw (user_pw),
--	key user_id (user_id(765)),
	key last_login (last_login),
	key last_logout (last_logout),
	key account_status (account_status),
	key online_status (online_status)
)
ENGINE=InnoDB default character set utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

CREATE INDEX part_of_user_id ON tig_users (user_id(255));
create table if not exists tig_nodes (
       nid bigint unsigned NOT NULL auto_increment,
       parent_nid bigint unsigned,
       uid bigint unsigned NOT NULL,

       node varchar(255) NOT NULL,

       primary key (nid),
       unique key tnode (parent_nid, uid, node),
       key node (node),
			 key uid (uid),
			 key parent_nid (parent_nid),
			 constraint tig_nodes_constr foreign key (uid) references tig_users (uid)
)
ENGINE=InnoDB default character set utf8 ROW_FORMAT=DYNAMIC;


create table if not exists tig_pairs (
       nid bigint unsigned,
       uid bigint unsigned NOT NULL,

       pkey varchar(255) NOT NULL,
       pval mediumtext,

       key pkey (pkey),
			 key uid (uid),
			 key nid (nid),
			 constraint tig_pairs_constr_1 foreign key (uid) references tig_users (uid),
			 constraint tig_pairs_constr_2 foreign key (nid) references tig_nodes (nid)
)
ENGINE=InnoDB default character set utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;


create table if not exists short_news (
  -- Automatic record ID
  snid            bigint unsigned NOT NULL auto_increment,
  -- Automaticly generated timestamp and automaticly updated on change
  publishing_time timestamp,
	-- Optional news type: 'shorts', 'minis', 'techs', 'funs'....
	news_type       varchar(10),
  -- Author JID
  author          varchar(128) NOT NULL,
  -- Short subject - this is short news, right?
  subject         varchar(128) NOT NULL,
  -- Short news message - this is short news, right?
  body            varchar(1024) NOT NULL,
  primary key(snid),
  key publishing_time (publishing_time),
  key author (author),
  key news_type (news_type)
)
ENGINE=InnoDB default character set utf8 ROW_FORMAT=DYNAMIC;


create table if not exists xmpp_stanza (
			 id bigint unsigned NOT NULL auto_increment,
			 stanza text NOT NULL,

			 primary key (id)
)
ENGINE=InnoDB default character set utf8 ROW_FORMAT=DYNAMIC;
