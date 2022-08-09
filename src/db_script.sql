/* Excecute this SQL script before databse part test
 * 测试数据库部分之前执行这个SQL脚本
 * Microsoft SQL Server need account-login environment like sa account.
 * Microsoft SQL Server 需要「账号-登入」环境, 比如sa账号
 */

create database work on (
    /* Databse name
     * 数据库名称
     */
    name     = "$db_name",
    /* Database file absolute path
     * 数据库文件的绝对路径, 扩展名为*.mdf
     */
    filename = "$db_file_dir\$db_name.mdf"
) log on (
    name     = "$db_name_log",
    filename = "$db_file_dir\$db_name_log.ldf"
)

create table work.dat (
    name   varchar(128),
    gender varchar(128),
    age    varchar(128)
)