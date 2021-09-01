-- HTML DB 2.1.0.00.39 SQL Script Export file
-- Exported 20:03 Wednesday September 1, 2021 by: SYSTEM
-- Scripts included:
--      exportregister
 
set define off
set verify off
set serveroutput on size 1000000
set feedback off
WHENEVER SQLERROR EXIT SQL.SQLCODE ROLLBACK
begin wwv_flow.g_import_in_progress := true; end; 
/
 
prompt  Set Credentials...
 
begin
 
  -- Assumes you are running the script connected to sqlplus as the owner (parsing schema) of the application or as the product schema.
  wwv_flow_api.set_security_group_id(p_security_group_id=>716215552617435);
 
end;
/

begin wwv_flow.g_import_in_progress := true; end;
/
begin 

select value into wwv_flow_api.g_nls_numeric_chars from nls_session_parameters where parameter='NLS_NUMERIC_CHARACTERS';

end;

/
begin execute immediate 'alter session set nls_numeric_characters=''.,''';

end;

/
begin wwv_flow.g_browser_language := 'en-us'; end;
/
prompt  Check Compatibility...
 
begin
 
-- This date identifies the minimum version required to import this file.
wwv_flow_api.set_version(p_version_yyyy_mm_dd=>'2005.05.01');
 
end;
/

begin wwv_flow.g_user := nvl(wwv_flow.g_user,'SYSTEM'); end;
/
-------------------------------
prompt ...Exporting Script File
--
begin
    wwv_flow_api.g_varchar2_table := wwv_flow_api.empty_varchar2_table;
    wwv_flow_api.g_varchar2_table(1) := '435245415445205441424C45202022524547495354455222200A202020280922464E414D4522205641524348415232283230292C200A09224C4E414D4522205641524348415232283230292C200A092241444841524E4F22205641524348415232283230';
    wwv_flow_api.g_varchar2_table(2) := '292C200A092241474522204E554D4245522832302C30292C200A09224349545922205641524348415232283230292C200A0922484F53504954414C22205641524348415232283337290A202020290A2F0A';
 
end;
/

 
declare
    l_name   varchar2(255);
begin
    l_name   := 'F725115383321482/exportregister';
    wwv_flow_api.import_script(
        p_name          => l_name,
        p_varchar2_table=> wwv_flow_api.g_varchar2_table,
        p_flow_id       => 4500,
        p_pathid        => null,
        p_filename      => 'exportregister',
        p_title         => 'exportregister',
        p_mime_type     => 'text/plain',
        p_dad_charset   => '',
        p_deleted_as_of => to_date('000101010000','YYYYMMDDHH24MI'),
        p_content_type  => 'BLOB',
        p_language      => '',
        p_description   => '',
        p_file_type     => 'SCRIPT',
        p_file_charset  => 'utf-8');
 
end;
/

--commit;
begin 
execute immediate 'alter session set nls_numeric_characters='''||wwv_flow_api.g_nls_numeric_chars||'''';
end;
/
set verify on
set feedback on
prompt  ...done
