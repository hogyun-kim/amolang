CREATE TABLE `component` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `name` varchar(20) NOT NULL,
   `parent_id` int(11) NOT NULL DEFAULT '-1',
   `arg_table` varchar(20) DEFAULT NULL,
   `arg_columns` varchar(100) DEFAULT NULL,
   `arg_params` varchar(100) DEFAULT NULL,
   `version` varchar(20) NOT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8
 
CREATE TABLE `dbinfo` (
   `dbtype` varchar(10) NOT NULL,
   `ip` varchar(16) NOT NULL,
   `port` int(11) NOT NULL,
   `dbname` varchar(65) NOT NULL,
   `username` varchar(20) NOT NULL,
   `password` varchar(20) NOT NULL
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;