-- Build Script
--     RDBMS           : Oracle 8.1.6
--     Generated With  :  
--     Generated On    : 2006-01-06 10:13:24
--     Generation Options
--         Generate Comments             : true
--         Generate Drop Statements      : true
--

-- Uncomment the following line for use of the logging facility (see last line also)
--spool .log

--  ----------------------------------------------------------------------------------------------------------------
--  Generate From
--    Model       : /foo/GFM.xmi
--    Model Type  : Physical
--    Metamodel   : Relational (http://www.metamatrix.com/metamodels/Relational)
--    Model UUID  : mmuuid:518a6900-6bbb-1fc5-9f13-9fdb85d04baa
--  ----------------------------------------------------------------------------------------------------------------

DROP SCHEMA GLOBALFORCEMGMT CASCADE;

-- ** NOTE: Replace "<USERID>" with the appropriate ID of the user **
-- CREATE SCHEMA GLOBALFORCEMGMT AUTHORIZATION <USERID>
CREATE SCHEMA GLOBALFORCEMGMT AUTHORIZATION GBLFORCE

-- (generated from GLOBALFORCEMGMT/ACFT_TYPE)

CREATE TABLE ACFT_TYPE
(
  ACFT_TYPE_ID      NUMERIC(20) NOT NULL,
  CAT_CODE          CHAR(6) NOT NULL,
  SUBCAT_CODE       CHAR(7),
  OWNER_ID          NUMERIC(11) NOT NULL,
  UPDATE_SEQNR      NUMERIC(15) NOT NULL,
  ENGINE_IND_CODE   CHAR(3)
)

-- (generated from GLOBALFORCEMGMT/ADDR)

CREATE TABLE ADDR
(
  ADDR_ID          NUMERIC(20) NOT NULL,
  PLACE_NAME_TXT   VARCHAR(100),
  CAT_CODE         CHAR(7) NOT NULL,
  OWNER_ID         NUMERIC(11) NOT NULL,
  UPDATE_SEQNR     NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/AFFL)

CREATE TABLE AFFL
(
  AFFL_ID                NUMERIC(20) NOT NULL,
  CAT_CODE               CHAR(7) NOT NULL,
  OWNER_ID               NUMERIC(11) NOT NULL,
  UPDATE_SEQNR           NUMERIC(15) NOT NULL,
  OBJ_TYPE_AFFIL_S_DTG   DATE NOT NULL,
  OBJ_TYPE_AFFIL_T_DTG   DATE NOT NULL
)

-- (generated from GLOBALFORCEMGMT/AFFL_GEOPOLITICAL)

CREATE TABLE AFFL_GEOPOLITICAL
(
  AFFL_ID        NUMERIC(20) NOT NULL,
  CODE           CHAR(4) NOT NULL,
  OWNER_ID       NUMERIC(11) NOT NULL,
  UPDATE_SEQNR   NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/ALIAS)

CREATE TABLE ALIAS
(
  ALIAS_ID        NUMERIC(20) NOT NULL,
  ALT_ID_NAME     VARCHAR(50),
  ALT_ID_TEXT     VARCHAR(50),
  ALIAS_S_DTG     DATE NOT NULL,
  ALIAS_T_DTG     DATE NOT NULL,
  ALIAS_REM_TXT   VARCHAR(100)
)

-- (generated from GLOBALFORCEMGMT/BILLET)

CREATE TABLE BILLET
(
  BILLET_ID                  NUMERIC(20) NOT NULL,
  BILLET_FORMAL_ABBRD_NAME   VARCHAR(100)
)
-- ==  10 STATEMENTS ============================================
-- (generated from GLOBALFORCEMGMT/BIN_zT_p_V1ETrerBB26v9P6jw___0)

CREATE TABLE BIN_zT_p_V1ETrerBB26v9P6jw___0
(
  ACFT_TYPE_ID      NUMERIC(20) NOT NULL,
  CAT_CODE          CHAR(6) NOT NULL,
  SUBCAT_CODE       CHAR(7),
  OWNER_ID          NUMERIC(11) NOT NULL,
  UPDATE_SEQNR      NUMERIC(15) NOT NULL,
  ENGINE_IND_CODE   CHAR(3)
)

-- (generated from GLOBALFORCEMGMT/CIV_PERS_TYPE)

CREATE TABLE CIV_PERS_TYPE
(
  PERS_TYPE_ID   NUMERIC(20) NOT NULL,
  CAT_CODE       CHAR(7)
)

-- (generated from GLOBALFORCEMGMT/CREW_PLATFORM)

CREATE TABLE CREW_PLATFORM
(
  CREW_PLATFORM_ID         NUMERIC(20) NOT NULL,
  CREW_FORMAL_ABBRD_NAME   VARCHAR(100)
)

-- (generated from GLOBALFORCEMGMT/CREW_PLATFORM_TYPE)

CREATE TABLE CREW_PLATFORM_TYPE
(
  CREW_PLTFM_TYPE_ID   NUMERIC(20) NOT NULL,
  OPRED_EQPT_TYPE_ID   NUMERIC(20)
)

-- (generated from GLOBALFORCEMGMT/ELCTRNC_EQPT_TYPE)

CREATE TABLE ELCTRNC_EQPT_TYPE
(
  ELCTRNC_EQPT_TYPE_ID   NUMERIC(20) NOT NULL,
  CAT_CODE               CHAR(4) NOT NULL,
  SUBCAT_CODE            CHAR(7),
  OWNER_ID               NUMERIC(11) NOT NULL,
  UPDATE_SEQNR           NUMERIC(15) NOT NULL
)


-- (generated from GLOBALFORCEMGMT/ENG_EQPT_TYPE)

CREATE TABLE ENG_EQPT_TYPE
(
  ENG_EQPT_TYPE_ID   NUMERIC(20) NOT NULL,
  CAT_CODE           CHAR(7) NOT NULL,
  OWNER_ID           NUMERIC(11) NOT NULL,
  UPDATE_SEQNR       NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/EQPT_TYPE)

CREATE TABLE EQPT_TYPE
(
  EQPT_TYPE_ID             NUMERIC(20) NOT NULL,
  CAT_CODE                 CHAR(7) NOT NULL,
  LOADED_WT_QTY            NUMERIC(12,3),
  UNLOADED_WT_QTY          NUMERIC(12,3),
  OWNER_ID                 NUMERIC(11) NOT NULL,
  UPDATE_SEQNR             NUMERIC(15) NOT NULL,
  EQPT_TYPE_ABBREV_NAME    VARCHAR(80),
  EQPT_TYPE_MODEL_NAME     VARCHAR(50),
  EQPT_TYPE_SERIES_NAME    VARCHAR(50),
  EQPT_TYPE_VARIANT_NAME   VARCHAR(50),
  EQPT_TYPE_RC             VARCHAR(6)
)

-- (generated from GLOBALFORCEMGMT/EXCTV_MIL_ORG_TYPE)

CREATE TABLE EXCTV_MIL_ORG_TYPE
(
  EXCTV_MIL_ORG_TYPE_ID   NUMERIC(20) NOT NULL,
  CAT_CODE                CHAR(6) NOT NULL,
  OWNER_ID                NUMERIC(11) NOT NULL,
  UPDATE_SEQNR            NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/FAC)

CREATE TABLE FAC
(
  FAC_ID                  NUMERIC(20) NOT NULL,
  CAT_CODE                CHAR(6) NOT NULL,
  PRIM_CONST_MATRL_CODE   CHAR(6),
  OWNER_ID                NUMERIC(11) NOT NULL,
  HEIGHT_DIM              NUMERIC(12,3),
  UPDATE_SEQNR            NUMERIC(15) NOT NULL,
  LENGTH_DIM              NUMERIC(12,3),
  WIDTH_DIM               NUMERIC(12,3)
)

-- (generated from GLOBALFORCEMGMT/FAC_TYPE)

CREATE TABLE FAC_TYPE
(
  FAC_TYPE_ID    NUMERIC(20) NOT NULL,
  CAT_CODE       CHAR(6) NOT NULL,
  OWNER_ID       NUMERIC(11) NOT NULL,
  UPDATE_SEQNR   NUMERIC(15) NOT NULL
)
-- ==  20 STATEMENTS ============================================
-- (generated from GLOBALFORCEMGMT/GOVEMP_TYPE)

CREATE TABLE GOVEMP_TYPE
(
  PERS_TYPE_ID               NUMERIC(20) NOT NULL,
  GOVT_EMPL_TYPE_MIN_GRADE   NUMERIC(20),
  GOVT_EMPL_TYPE_MAX_GRADE   NUMERIC(20) NOT NULL,
  GOVT_EMPL_TYPE_OCC         NUMERIC(20)
)

-- (generated from GLOBALFORCEMGMT/GOVT_ORG_TYPE)

CREATE TABLE GOVT_ORG_TYPE
(
  GOVT_ORG_TYPE_ID   NUMERIC(20) NOT NULL,
  CAT_CODE           CHAR(7) NOT NULL,
  MAIN_ACTV_CODE     CHAR(7),
  OWNER_ID           NUMERIC(11) NOT NULL,
  UPDATE_SEQNR       NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/LAND_WEAPON_TYPE)

CREATE TABLE LAND_WEAPON_TYPE
(
  LAND_WEAPON_TYPE_ID      NUMERIC(20) NOT NULL,
  CAT_CODE                 CHAR(6) NOT NULL,
  SUBCAT_CODE              CHAR(7),
  CALIBRE_TXT              VARCHAR(15),
  FIRE_GUIDANCE_IND_CODE   CHAR(3),
  OWNER_ID                 NUMERIC(11) NOT NULL,
  UPDATE_SEQNR             NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/MAT)

CREATE TABLE MAT
(
  MAT_ID                NUMERIC(20) NOT NULL,
  SERIAL_NO_ID_TXT      VARCHAR(50),
  LOT_IDENTIFIC_TXT     VARCHAR(100),
  BODY_COLOUR_CODE      CHAR(7),
  MARKING_CODE          CHAR(6),
  MARKING_COLOUR_CODE   CHAR(6),
  OWNER_ID              NUMERIC(11) NOT NULL,
  UPDATE_SEQNR          NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/MAT_TYPE)

CREATE TABLE MAT_TYPE
(
  MAT_TYPE_ID         NUMERIC(20) NOT NULL,
  CAT_CODE            CHAR(3) NOT NULL,
  STOCK_NO_TXT        VARCHAR(15),
  RPTBL_ITEM_TXT      VARCHAR(6),
  MAX_HEIGHT_DIM      NUMERIC(12,3),
  SUPPLY_CLASS_CODE   CHAR(5),
  OWNER_ID            NUMERIC(11) NOT NULL,
  UPDATE_SEQNR        NUMERIC(15) NOT NULL,
  MAX_LENGTH_DIM      NUMERIC(12,3),
  MAX_WIDTH_DIM       NUMERIC(12,3),
  STOCK_NO_NAME       VARCHAR(50),
  MSN_ESS_EQUIP_CD    CHAR(3)
)

-- (generated from GLOBALFORCEMGMT/MILTRY_PERS_TYPE)

CREATE TABLE MILTRY_PERS_TYPE
(
  PERS_TYPE_ID                NUMERIC(20) NOT NULL,
  MIL_PERS_TYPE_GRADE         NUMERIC(20) NOT NULL,
  MIL_PERS_TYPE_RANK          NUMERIC(20) NOT NULL,
  MIL_PERS_TYPE_PRI_OCC       NUMERIC(20) NOT NULL,
  MIL_PERS_TYPE_SKILL_LEVEL   NUMERIC(20),
  MIL_PERS_TYPE_SEC_OCC       NUMERIC(20)
)

-- (generated from GLOBALFORCEMGMT/MIL_ORG_TYPE)

CREATE TABLE MIL_ORG_TYPE
(
  MIL_ORG_TYPE_ID   NUMERIC(20) NOT NULL,
  CAT_CODE          CHAR(7) NOT NULL,
  OWNER_ID          NUMERIC(11) NOT NULL,
  UPDATE_SEQNR      NUMERIC(15) NOT NULL,
  SERVICE_CODE      CHAR(7) NOT NULL,
  COMPONENT_CODE    CHAR(6) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/MIL_POST_TYPE)

CREATE TABLE MIL_POST_TYPE
(
  MIL_POST_TYPE_ID   NUMERIC(20) NOT NULL,
  CAT_CODE           CHAR(7) NOT NULL,
  RANK_CODE          CHAR(5),
  OWNER_ID           NUMERIC(11) NOT NULL,
  UPDATE_SEQNR       NUMERIC(15) NOT NULL,
  POSITION_TYPE_CD   CHAR(7) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/MIL_POST_TYPE_SKILL_TYPE_DET)

CREATE TABLE MIL_POST_TYPE_SKILL_TYPE_DET
(
  MIL_POST_TYPE_ID                 NUMERIC(20) NOT NULL,
  SKILL_TYPE_ID                    NUMERIC(20) NOT NULL,
  MIL_POST_TYPE_SKILL_TYP_DET_IX   NUMERIC(20) NOT NULL,
  POST_TYP_SKILL_TYP_DET_S_DTG     DATE NOT NULL,
  POST_TYP_SKILL_TYP_DET_T_DTG     DATE NOT NULL,
  POST_TYP_SKILL_TYP_DET_VAR_CD    NUMERIC(20) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/MISC_EQPT_TYPE)

CREATE TABLE MISC_EQPT_TYPE
(
  MISC_EQPT_TYPE_ID   NUMERIC(20) NOT NULL,
  CAT_CODE            CHAR(7) NOT NULL,
  OWNER_ID            NUMERIC(11) NOT NULL,
  UPDATE_SEQNR        NUMERIC(15) NOT NULL
)
-- ==  30 STATEMENTS ============================================
-- (generated from GLOBALFORCEMGMT/NBC_EQPT_TYPE)

CREATE TABLE NBC_EQPT_TYPE
(
  NBC_EQPT_TYPE_ID   NUMERIC(20) NOT NULL,
  CAT_CODE           CHAR(7) NOT NULL,
  OWNER_ID           NUMERIC(11) NOT NULL,
  UPDATE_SEQNR       NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/OBJECT_ITEM_ALIAS)

CREATE TABLE OBJECT_ITEM_ALIAS
(
  ALIAS_ID               NUMERIC(20) NOT NULL,
  OBJ_ITEM_ID            NUMERIC(20) NOT NULL,
  OBJ_ITEM_ALIAS_IX      NUMERIC(20) NOT NULL,
  OBJ_ITEM_ALIAS_S_DTG   DATE NOT NULL,
  OBJ_ITEM_ALIAS_T_DTG   DATE NOT NULL
)

-- (generated from GLOBALFORCEMGMT/OBJECT_TYPE_ALIAS)

CREATE TABLE OBJECT_TYPE_ALIAS
(
  ALIAS_ID               NUMERIC(20) NOT NULL,
  OBJ_TYPE_ID            NUMERIC(20) NOT NULL,
  OBJ_TYPE_ALIAS_IX      NUMERIC(20) NOT NULL,
  OBJ_TYPE_ALIAS_S_DTG   DATE NOT NULL,
  OBJ_TYPE_ALIAS_T_DTG   DATE NOT NULL
)

-- (generated from GLOBALFORCEMGMT/OBJT_ESTAB_OBJT_DET_ROLE_ASSOC)

CREATE TABLE OBJT_ESTAB_OBJT_DET_ROLE_ASSOC
(
  ESTABD_OBJ_TYPE_ID             NUMERIC(20) NOT NULL,
  OBJ_TYPE_ESTAB_IX              NUMERIC(20) NOT NULL,
  OBJ_TYPE_ESTAB_OBJT_DET_IX     NUMERIC(20) NOT NULL,
  SKILL_TYPE_ID                  NUMERIC(20) NOT NULL,
  OBTJ_ESTAB_DET_ROLE_ASOC_IX    NUMERIC(20) NOT NULL,
  OBJ_TYP_ESTAB_DET_ROLE_S_DTG   DATE,
  OBJ_TYP_ESTAB_DET_ROLE_T_DTG   DATE
)

-- (generated from GLOBALFORCEMGMT/OBJ_ITEM)

CREATE TABLE OBJ_ITEM
(
  OBJ_ITEM_ID          NUMERIC(20) NOT NULL,
  CAT_CODE             CHAR(3) NOT NULL,
  NAME                 VARCHAR(100) NOT NULL,
  ALTN_IDENTIFIC_TXT   VARCHAR(255),
  OWNER_ID             NUMERIC(11) NOT NULL,
  UPDATE_SEQNR         NUMERIC(15) NOT NULL,
  OBJ_ITEM_S_DTG       DATE NOT NULL,
  OBJ_ITEM_T_DTG       DATE NOT NULL,
  SYM_2525B            VARCHAR(15)
)

-- (generated from GLOBALFORCEMGMT/OBJ_ITEM_ADDR)

CREATE TABLE OBJ_ITEM_ADDR
(
  OBJ_ITEM_ID        NUMERIC(20) NOT NULL,
  ADDR_ID            NUMERIC(20) NOT NULL,
  OBJ_ITEM_ADDR_IX   NUMERIC(20) NOT NULL,
  CALL_SIGN_TXT      VARCHAR(50),
  TRNS_IND_CODE      CHAR(3),
  RPTD_ID            NUMERIC(20),
  OWNER_ID           NUMERIC(11) NOT NULL,
  UPDATE_SEQNR       NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/OBJ_ITEM_AFFL)

CREATE TABLE OBJ_ITEM_AFFL
(
  OBJ_ITEM_ID        NUMERIC(20) NOT NULL,
  AFFL_ID            NUMERIC(20) NOT NULL,
  OBJ_ITEM_AFFL_IX   NUMERIC(20) NOT NULL,
  RPTD_ID            NUMERIC(20) NOT NULL,
  OWNER_ID           NUMERIC(11) NOT NULL,
  UPDATE_SEQNR       NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/OBJ_ITEM_ASSOC)

CREATE TABLE OBJ_ITEM_ASSOC
(
  SUBJ_OBJ_ITEM_ID            NUMERIC(20) NOT NULL,
  OBJ_OBJ_ITEM_ID             NUMERIC(20) NOT NULL,
  OBJ_ITEM_ASSOC_IX           NUMERIC(20) NOT NULL,
  CAT_CODE                    CHAR(7) NOT NULL,
  ACT_TASK_ID                 NUMERIC(20),
  SUBCAT_CODE                 CHAR(7),
  OWNER_ID                    NUMERIC(11) NOT NULL,
  UPDATE_SEQNR                NUMERIC(15) NOT NULL,
  OBJ_ITEM_ASSOC_S_DTG        DATE NOT NULL,
  OBJ_ITEM_ASSOC_T_DTG        DATE NOT NULL,
  OBJ_ITEM_ASSOC_LABEL        VARCHAR(50),
  OBJ_ITEM_ASSC_ROLE_IND_CD   CHAR(2)
)

-- (generated from GLOBALFORCEMGMT/OBJ_ITEM_ASSOC_ROLE_ASSOC)

CREATE TABLE OBJ_ITEM_ASSOC_ROLE_ASSOC
(
  SUBJ_OBJ_ITEM_ID                 NUMERIC(20) NOT NULL,
  OBJ_OBJ_ITEM_ID                  NUMERIC(20) NOT NULL,
  OBJ_ITEM_ASSOC_IX                NUMERIC(20) NOT NULL,
  ESTABD_OBJ_TYPE_ID               NUMERIC(20) NOT NULL,
  OBJ_TYPE_ESTAB_IX                NUMERIC(20) NOT NULL,
  OBJ_TYPE_ESTAB_OBJT_DET_IX       NUMERIC(20) NOT NULL,
  OBJ_ITEM_ASSOC_ROLE_ASSOC_IX     NUMERIC(20) NOT NULL,
  OBJ_ITEM_ASSOC_ROLE_ASSC_S_DTG   DATE NOT NULL,
  OBJ_ITEM_ASSOC_ROLE_ASSC_T_DTG   DATE NOT NULL
)

-- (generated from GLOBALFORCEMGMT/OBJ_ITEM_OBJ_TYPE_ESTAB)

CREATE TABLE OBJ_ITEM_OBJ_TYPE_ESTAB
(
  OBJ_ITEM_ID                     NUMERIC(20) NOT NULL,
  ESTABD_OBJ_TYPE_ID              NUMERIC(20) NOT NULL,
  OBJ_TYPE_ESTAB_IX               NUMERIC(20) NOT NULL,
  OBJ_ITEM_OBJ_TYPE_ESTAB_IX      NUMERIC(20) NOT NULL,
  EFFCTV_DATE                     DATE NOT NULL,
  OWNER_ID                        NUMERIC(11) NOT NULL,
  UPDATE_SEQNR                    NUMERIC(15) NOT NULL,
  OBJI_OBJT_ESTAB_CAT_CODE        CHAR(6),
  OBJ_ITEM_OBJ_TYPE_ESTAB_S_DTG   DATE NOT NULL,
  OBJ_ITEM_OBJ_TYPE_ESTAB_T_DTG   DATE NOT NULL
)
-- ==  40 STATEMENTS ============================================
-- (generated from GLOBALFORCEMGMT/OBJ_ITEM_TYPE)

CREATE TABLE OBJ_ITEM_TYPE
(
  OBJ_ITEM_ID        NUMERIC(20) NOT NULL,
  OBJ_TYPE_ID        NUMERIC(20) NOT NULL,
  OBJ_ITEM_TYPE_IX   NUMERIC(20) NOT NULL,
  RPTD_ID            NUMERIC(20) NOT NULL,
  OWNER_ID           NUMERIC(11) NOT NULL,
  UPDATE_SEQNR       NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/OBJ_TYPE)

CREATE TABLE OBJ_TYPE
(
  OBJ_TYPE_ID      NUMERIC(20) NOT NULL,
  CAT_CODE         CHAR(3) NOT NULL,
  NAME             VARCHAR(100) NOT NULL,
  DUMMY_IND_CODE   CHAR(3) NOT NULL,
  OWNER_ID         NUMERIC(11) NOT NULL,
  UPDATE_SEQNR     NUMERIC(15) NOT NULL,
  OBJ_TYPE_S_DTG   DATE NOT NULL,
  OBJ_TYPE_T_DTG   DATE NOT NULL,
  SYM_2525B        VARCHAR(15)
)

-- (generated from GLOBALFORCEMGMT/OBJ_TYPE_AFFL)

CREATE TABLE OBJ_TYPE_AFFL
(
  OBJ_TYPE_ID            NUMERIC(20) NOT NULL,
  AFFL_ID                NUMERIC(20) NOT NULL,
  OBJ_TYPE_AFFL_IX       NUMERIC(20) NOT NULL,
  OWNER_ID               NUMERIC(11) NOT NULL,
  UPDATE_SEQNR           NUMERIC(15) NOT NULL,
  OBJ_TYPE_AFFIL_S_DTG   DATE,
  OBJ_TYPE_AFFIL_T_DTG   DATE
)

-- (generated from GLOBALFORCEMGMT/OBJ_TYPE_ESTAB)

CREATE TABLE OBJ_TYPE_ESTAB
(
  ESTABD_OBJ_TYPE_ID     NUMERIC(20) NOT NULL,
  OBJ_TYPE_ESTAB_IX      NUMERIC(20) NOT NULL,
  CAT_CODE               CHAR(4),
  EFFCTV_DATE            DATE NOT NULL,
  OPERAT_MODE_CODE       CHAR(3),
  ENVIRON_COND_CODE      CHAR(6),
  NAME                   VARCHAR(80),
  OWNER_ID               NUMERIC(11) NOT NULL,
  UPDATE_SEQNR           NUMERIC(15) NOT NULL,
  OBJ_TYPE_ESTAB_S_DTG   DATE NOT NULL,
  OBJ_TYPE_ESTAB_T_DTG   DATE NOT NULL
)

-- (generated from GLOBALFORCEMGMT/OBJ_TYPE_ESTAB_OBJT_DET)

CREATE TABLE OBJ_TYPE_ESTAB_OBJT_DET
(
  ESTABD_OBJ_TYPE_ID             NUMERIC(20) NOT NULL,
  OBJ_TYPE_ESTAB_IX              NUMERIC(20) NOT NULL,
  OBJ_TYPE_ESTAB_OBJT_DET_IX     NUMERIC(20) NOT NULL,
  MAJOR_PART_IND_CODE            CHAR(2),
  QTY                            NUMERIC(9) NOT NULL,
  DET_OBJ_TYPE_ESTAB_IX          NUMERIC(20),
  DET_OBJ_TYPE_ID                NUMERIC(20) NOT NULL,
  OWNER_ID                       NUMERIC(11) NOT NULL,
  UPDATE_SEQNR                   NUMERIC(15) NOT NULL,
  OBJ_TYPE_ESTAB_OBJ_DET_S_DTG   DATE NOT NULL,
  OBJ_TYPE_ESTAB_OBJ_DET_T_DTG   DATE NOT NULL,
  OBJ_TYPE_ESTAB_LABEL           VARCHAR(50),
  REQUIRED_QTY                   NUMERIC(9) NOT NULL,
  PRIN_END_ITEM_IND_CODE         CHAR(3),
  CAT_CODE                       CHAR(7) NOT NULL,
  SUBCAT_CODE                    CHAR(6),
  OBJT_ESTAB_DET_ROLE_IND_CD     CHAR(2)
)

-- (generated from GLOBALFORCEMGMT/ORG)

CREATE TABLE ORG
(
  ORG_ID             NUMERIC(20) NOT NULL,
  CAT_CODE           CHAR(3) NOT NULL,
  OWNER_ID           NUMERIC(11) NOT NULL,
  NICKNAME_NAME      VARCHAR(100),
  UPDATE_SEQNR       NUMERIC(15) NOT NULL,
  ORG_DERIVED_NAME   VARCHAR(100),
  ORG_SHORT_NAME     VARCHAR(10)
)

-- (generated from GLOBALFORCEMGMT/ORG_ORG_TYPE_ESTAB)

CREATE TABLE ORG_ORG_TYPE_ESTAB
(
  ORG_ORGT_M_DTG          DATE NOT NULL,
  ORG_ORGT_VAR_CODE       NUMERIC(20),
  OBJ_ITEM_ID             NUMERIC(20) NOT NULL,
  ESTABD_OBJ_TYPE_ID      NUMERIC(20) NOT NULL,
  OBJ_TYPE_ESTAB_IX       NUMERIC(20) NOT NULL,
  ORG_ORG_TYPE_ESTAB_IX   NUMERIC(20) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/ORG_TYPE)

CREATE TABLE ORG_TYPE
(
  ORG_TYPE_ID             NUMERIC(20) NOT NULL,
  CAT_CODE                CHAR(7) NOT NULL,
  OWNER_ID                NUMERIC(11) NOT NULL,
  CMD_FUNCTION_IND_CODE   CHAR(3),
  UPDATE_SEQNR            NUMERIC(15) NOT NULL,
  CMD_AND_CTRL_CAT_CODE   CHAR(3),
  DESCR_TXT               VARCHAR(50),
  SHORT_NAME              VARCHAR(10)
)

-- (generated from GLOBALFORCEMGMT/PERS_TYPE)

CREATE TABLE PERS_TYPE
(
  PERS_TYPE_ID        NUMERIC(20) NOT NULL,
  CAT_CODE            CHAR(6) NOT NULL,
  RANK_CODE           CHAR(5),
  SUBCAT_CODE         CHAR(7),
  OWNER_ID            NUMERIC(11) NOT NULL,
  UPDATE_SEQNR        NUMERIC(15) NOT NULL,
  PERS_TYPE_REM_TXT   VARCHAR(100)
)

-- (generated from GLOBALFORCEMGMT/PHYSCL_ADDR)

CREATE TABLE PHYSCL_ADDR
(
  ADDR_ID             NUMERIC(20) NOT NULL,
  CAT_CODE            CHAR(7) NOT NULL,
  POSTAL_BOX_TXT      VARCHAR(15),
  STREET_ADDTNL_TXT   VARCHAR(50),
  POSTBOX_ID_TXT      VARCHAR(15),
  RSDNC_TXT           VARCHAR(50),
  STREET_TXT          VARCHAR(50),
  POSTAL_CODE_TXT     VARCHAR(15),
  CITY_TXT            VARCHAR(50),
  GEO_TXT             VARCHAR(50),
  OWNER_ID            NUMERIC(11) NOT NULL,
  UPDATE_SEQNR        NUMERIC(15) NOT NULL
)
-- ==  50 STATEMENTS ============================================
-- (generated from GLOBALFORCEMGMT/RAILCAR_TYPE)

CREATE TABLE RAILCAR_TYPE
(
  RAILCAR_TYPE_ID   NUMERIC(20) NOT NULL,
  CAT_CODE          CHAR(7) NOT NULL,
  SUBCAT_CODE       CHAR(7),
  GAUGE_DIM         NUMERIC(12,3),
  OWNER_ID          NUMERIC(11) NOT NULL,
  UPDATE_SEQNR      NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/SKILL_TYPE)

CREATE TABLE SKILL_TYPE
(
  SKILL_TYPE_ID           NUMERIC(20) NOT NULL,
  SKILL_TYPE_ATT_CODE     VARCHAR(15),
  SKILL_TYPE_ATT_TXT      VARCHAR(50),
  SKILL_TYPE_ATT_REMARK   VARCHAR(255),
  SKILL_TYPE_S_DTG        DATE NOT NULL,
  SKILL_TYPE_T_DTG        DATE NOT NULL,
  SKILL_TYPE_ATT_ID       NUMERIC(20) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/SKILL_TYPE_ATTRIBUTE)

CREATE TABLE SKILL_TYPE_ATTRIBUTE
(
  SKILL_TYPE_ATT_ID     NUMERIC(20) NOT NULL,
  SKILL_TYPE_ATT_NAME   VARCHAR(50)
)

-- (generated from GLOBALFORCEMGMT/UNIT)

CREATE TABLE UNIT
(
  UNIT_ID             NUMERIC(20) NOT NULL,
  FORMAL_ABBRD_NAME   VARCHAR(100) NOT NULL,
  OWNER_ID            NUMERIC(11) NOT NULL,
  UPDATE_SEQNR        NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/UNIT_TYPE)

CREATE TABLE UNIT_TYPE
(
  UNIT_TYPE_ID                NUMERIC(20) NOT NULL,
  CAT_CODE                    CHAR(7) NOT NULL,
  ARM_CAT_CODE                CHAR(7) NOT NULL,
  PRINCIPAL_EQPT_TYPE_ID      NUMERIC(20),
  ARM_SPCLSN_CODE             CHAR(7),
  SUPPL_SPCLSN_CODE           CHAR(7),
  SIZE_CODE                   CHAR(6),
  GEN_MOB_CODE                CHAR(6),
  SUPPORTED_MIL_ORG_TYPE_ID   NUMERIC(20),
  QUAL_CODE                   CHAR(6),
  OWNER_ID                    NUMERIC(11) NOT NULL,
  UPDATE_SEQNR                NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/VEHICLE_TYPE)

CREATE TABLE VEHICLE_TYPE
(
  VEHICLE_TYPE_ID   NUMERIC(20) NOT NULL,
  CAT_CODE          CHAR(6) NOT NULL,
  OWNER_ID          NUMERIC(11) NOT NULL,
  UPDATE_SEQNR      NUMERIC(15) NOT NULL
)

-- (generated from GLOBALFORCEMGMT/VESSEL_TYPE)

CREATE TABLE VESSEL_TYPE
(
  VESSEL_TYPE_ID   NUMERIC(20) NOT NULL,
  CAT_CODE         CHAR(6) NOT NULL,
  SUBCAT_CODE      CHAR(7),
  OWNER_ID         NUMERIC(11) NOT NULL,
  UPDATE_SEQNR     NUMERIC(15) NOT NULL
);

ALTER TABLE ACFT_TYPE
  ADD CONSTRAINT PRIMARY_1
    PRIMARY KEY (ACFT_TYPE_ID)

ALTER TABLE ADDR
  ADD CONSTRAINT PK_ADDR
    PRIMARY KEY (ADDR_ID)

ALTER TABLE AFFL
  ADD CONSTRAINT PK_AFFL
    PRIMARY KEY (AFFL_ID)
-- ==  60 STATEMENTS ============================================
ALTER TABLE AFFL_GEOPOLITICAL
  ADD CONSTRAINT PK_AFFL_GEOPOLITICAL
    PRIMARY KEY (AFFL_ID)

ALTER TABLE ALIAS
  ADD CONSTRAINT PK_ALIAS
    PRIMARY KEY (ALIAS_ID)

ALTER TABLE BILLET
  ADD CONSTRAINT PK_BILLET
    PRIMARY KEY (BILLET_ID)

ALTER TABLE CIV_PERS_TYPE
  ADD CONSTRAINT PK_CIV_PERS_TYPE
    PRIMARY KEY (PERS_TYPE_ID)

ALTER TABLE CREW_PLATFORM
  ADD CONSTRAINT PK_CREW_PLATFORM
    PRIMARY KEY (CREW_PLATFORM_ID)

ALTER TABLE CREW_PLATFORM_TYPE
  ADD CONSTRAINT PK_CREW_PLATFORM_TYPE
    PRIMARY KEY (CREW_PLTFM_TYPE_ID)

ALTER TABLE ELCTRNC_EQPT_TYPE
  ADD CONSTRAINT PK_ELCTRNC_EQPT_TYPE
    PRIMARY KEY (ELCTRNC_EQPT_TYPE_ID)

ALTER TABLE ENG_EQPT_TYPE
  ADD CONSTRAINT PK_ENG_EQPT_TYPE
    PRIMARY KEY (ENG_EQPT_TYPE_ID)

ALTER TABLE EQPT_TYPE
  ADD CONSTRAINT PK_EQPT_TYPE
    PRIMARY KEY (EQPT_TYPE_ID)

ALTER TABLE EXCTV_MIL_ORG_TYPE
  ADD CONSTRAINT PK_EXCTV_MIL_ORG_TYPE
    PRIMARY KEY (EXCTV_MIL_ORG_TYPE_ID)
-- ==  70 STATEMENTS ============================================
ALTER TABLE FAC
  ADD CONSTRAINT PK_FAC
    PRIMARY KEY (FAC_ID)

ALTER TABLE FAC_TYPE
  ADD CONSTRAINT PK_FAC_TYPE
    PRIMARY KEY (FAC_TYPE_ID)

ALTER TABLE GOVEMP_TYPE
  ADD CONSTRAINT PK_GOVEMP_TYPE
    PRIMARY KEY (PERS_TYPE_ID)

ALTER TABLE GOVT_ORG_TYPE
  ADD CONSTRAINT PK_GOVT_ORG_TYPE
    PRIMARY KEY (GOVT_ORG_TYPE_ID)

ALTER TABLE LAND_WEAPON_TYPE
  ADD CONSTRAINT PK_LAND_WEAPON_TYPE
    PRIMARY KEY (LAND_WEAPON_TYPE_ID)

ALTER TABLE MAT
  ADD CONSTRAINT PK_MAT
    PRIMARY KEY (MAT_ID)

ALTER TABLE MAT_TYPE
  ADD CONSTRAINT PK_MAT_TYPE
    PRIMARY KEY (MAT_TYPE_ID)

ALTER TABLE MILTRY_PERS_TYPE
  ADD CONSTRAINT PK_MILTRY_PERS_TYPE
    PRIMARY KEY (PERS_TYPE_ID)

ALTER TABLE MIL_ORG_TYPE
  ADD CONSTRAINT PK_MIL_ORG_TYPE
    PRIMARY KEY (MIL_ORG_TYPE_ID)

ALTER TABLE MIL_POST_TYPE
  ADD CONSTRAINT PK_MIL_POST_TYPE
    PRIMARY KEY (MIL_POST_TYPE_ID)

ALTER TABLE MIL_POST_TYPE_SKILL_TYPE_DET
  ADD CONSTRAINT PK_SKILL_TYPE_DET
    PRIMARY KEY (MIL_POST_TYPE_ID,SKILL_TYPE_ID,MIL_POST_TYPE_SKILL_TYP_DET_IX)
-- ==  80 STATEMENTS ============================================
ALTER TABLE MISC_EQPT_TYPE
  ADD CONSTRAINT PK_MISC_EQPT_TYPE
    PRIMARY KEY (MISC_EQPT_TYPE_ID)

ALTER TABLE NBC_EQPT_TYPE
  ADD CONSTRAINT PK_NBC_EQPT_TYPE
    PRIMARY KEY (NBC_EQPT_TYPE_ID)

ALTER TABLE OBJECT_ITEM_ALIAS
  ADD CONSTRAINT PK_OBJECT_ITEM_ALIAS
    PRIMARY KEY (ALIAS_ID,OBJ_ITEM_ID,OBJ_ITEM_ALIAS_IX)

ALTER TABLE OBJECT_TYPE_ALIAS
  ADD CONSTRAINT PK_OBJECT_TYPE_ALIAS
    PRIMARY KEY (ALIAS_ID,OBJ_TYPE_ID,OBJ_TYPE_ALIAS_IX)

ALTER TABLE OBJT_ESTAB_OBJT_DET_ROLE_ASSOC
  ADD CONSTRAINT PK_OBJT_DET_ROLE_ASSOC
    PRIMARY KEY (ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX,OBJ_TYPE_ESTAB_OBJT_DET_IX,SKILL_TYPE_ID,OBTJ_ESTAB_DET_ROLE_ASOC_IX)

ALTER TABLE OBJ_ITEM
  ADD CONSTRAINT PK_OBJ_ITEM
    PRIMARY KEY (OBJ_ITEM_ID)

ALTER TABLE OBJ_ITEM_ADDR
  ADD CONSTRAINT PK_OBJ_ITEM_ADDR
    PRIMARY KEY (OBJ_ITEM_ID,ADDR_ID,OBJ_ITEM_ADDR_IX)

ALTER TABLE OBJ_ITEM_AFFL
  ADD CONSTRAINT PK_OBJ_ITEM_AFFL
    PRIMARY KEY (OBJ_ITEM_ID,AFFL_ID,OBJ_ITEM_AFFL_IX)

ALTER TABLE OBJ_ITEM_ASSOC
  ADD CONSTRAINT PK_OBJ_ITEM_ASSOC
    PRIMARY KEY (SUBJ_OBJ_ITEM_ID,OBJ_OBJ_ITEM_ID,OBJ_ITEM_ASSOC_IX)

ALTER TABLE OBJ_ITEM_ASSOC_ROLE_ASSOC
  ADD CONSTRAINT PK_ROLE_ASSOC
    PRIMARY KEY (SUBJ_OBJ_ITEM_ID,OBJ_OBJ_ITEM_ID,OBJ_ITEM_ASSOC_IX,ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX,OBJ_TYPE_ESTAB_OBJT_DET_IX,OBJ_ITEM_ASSOC_ROLE_ASSOC_IX)
-- ==  90 STATEMENTS ============================================
ALTER TABLE OBJ_ITEM_OBJ_TYPE_ESTAB
  ADD CONSTRAINT PK_OBJ_ITEM_OBJ_TYPE_ESTAB
    PRIMARY KEY (OBJ_ITEM_ID,ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX,OBJ_ITEM_OBJ_TYPE_ESTAB_IX)

ALTER TABLE OBJ_ITEM_TYPE
  ADD CONSTRAINT PK_OBJ_ITEM_TYPE
    PRIMARY KEY (OBJ_ITEM_ID,OBJ_TYPE_ID,OBJ_ITEM_TYPE_IX)

ALTER TABLE OBJ_TYPE
  ADD CONSTRAINT PK_OBJ_TYPE
    PRIMARY KEY (OBJ_TYPE_ID)

ALTER TABLE OBJ_TYPE_AFFL
  ADD CONSTRAINT PK_OBJ_TYPE_AFFL
    PRIMARY KEY (OBJ_TYPE_ID,AFFL_ID,OBJ_TYPE_AFFL_IX)

ALTER TABLE OBJ_TYPE_ESTAB
  ADD CONSTRAINT PK_OBJ_TYPE_ESTAB
    PRIMARY KEY (ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX)

ALTER TABLE OBJ_TYPE_ESTAB_OBJT_DET
  ADD CONSTRAINT PK_OBJ_TYPE_ESTAB_OBJT_DET
    PRIMARY KEY (ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX,OBJ_TYPE_ESTAB_OBJT_DET_IX)

ALTER TABLE ORG
  ADD CONSTRAINT PK_ORG
    PRIMARY KEY (ORG_ID)

ALTER TABLE ORG_ORG_TYPE_ESTAB
  ADD CONSTRAINT PK_ORG_ORG_TYPE_ESTAB
    PRIMARY KEY (OBJ_ITEM_ID,ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX,ORG_ORG_TYPE_ESTAB_IX)

ALTER TABLE ORG_TYPE
  ADD CONSTRAINT PK_ORG_TYPE
    PRIMARY KEY (ORG_TYPE_ID)

ALTER TABLE PERS_TYPE
  ADD CONSTRAINT PK_PERS_TYPE
    PRIMARY KEY (PERS_TYPE_ID)
-- ==  100 STATEMENTS ============================================
ALTER TABLE PHYSCL_ADDR
  ADD CONSTRAINT PK_PHYSCL_ADDR
    PRIMARY KEY (ADDR_ID)

ALTER TABLE SKILL_TYPE
  ADD CONSTRAINT PK_SKILL_TYPE
    PRIMARY KEY (SKILL_TYPE_ID)

ALTER TABLE SKILL_TYPE_ATTRIBUTE
  ADD CONSTRAINT PK_SKILL_TYPE_ATTRIBUTE
    PRIMARY KEY (SKILL_TYPE_ATT_ID)

ALTER TABLE UNIT
  ADD CONSTRAINT PK_UNIT
    PRIMARY KEY (UNIT_ID)

ALTER TABLE UNIT_TYPE
  ADD CONSTRAINT PK_UNIT_TYPE
    PRIMARY KEY (UNIT_TYPE_ID)

ALTER TABLE VEHICLE_TYPE
  ADD CONSTRAINT PK_VEHICLE_TYPE
    PRIMARY KEY (VEHICLE_TYPE_ID)

ALTER TABLE VESSEL_TYPE
  ADD CONSTRAINT PK_VESSEL_TYPE
    PRIMARY KEY (VESSEL_TYPE_ID)

ALTER TABLE ACFT_TYPE
  ADD CONSTRAINT ACFT_TYPE_IBFK_1
    FOREIGN KEY (ACFT_TYPE_ID)
    REFERENCES EQPT_TYPE(EQPT_TYPE_ID)

ALTER TABLE AFFL_GEOPOLITICAL
  ADD CONSTRAINT AFFL_GEOPOLITICAL_IBFK_1
    FOREIGN KEY (AFFL_ID)
    REFERENCES AFFL(AFFL_ID)

ALTER TABLE BILLET
  ADD CONSTRAINT BILLET_IBFK_1
    FOREIGN KEY (BILLET_ID)
    REFERENCES ORG(ORG_ID)
-- ==  110 STATEMENTS ============================================
ALTER TABLE CIV_PERS_TYPE
  ADD CONSTRAINT CIV_PERS_TYPE_IBFK_1
    FOREIGN KEY (PERS_TYPE_ID)
    REFERENCES PERS_TYPE(PERS_TYPE_ID)

ALTER TABLE CREW_PLATFORM
  ADD CONSTRAINT CREW_PLATFORM_IBFK_1
    FOREIGN KEY (CREW_PLATFORM_ID)
    REFERENCES ORG(ORG_ID)

ALTER TABLE CREW_PLATFORM_TYPE
  ADD CONSTRAINT CREW_PLATFORM_TYPE_IBFK_2
    FOREIGN KEY (CREW_PLTFM_TYPE_ID)
    REFERENCES MIL_ORG_TYPE(MIL_ORG_TYPE_ID)

ALTER TABLE CREW_PLATFORM_TYPE
  ADD CONSTRAINT CREW_PLATFORM_TYPE_IBFK_1
    FOREIGN KEY (OPRED_EQPT_TYPE_ID)
    REFERENCES EQPT_TYPE(EQPT_TYPE_ID)

ALTER TABLE ELCTRNC_EQPT_TYPE
  ADD CONSTRAINT ELCTRNC_EQPT_TYPE_IBFK_1
    FOREIGN KEY (ELCTRNC_EQPT_TYPE_ID)
    REFERENCES EQPT_TYPE(EQPT_TYPE_ID)

ALTER TABLE ENG_EQPT_TYPE
  ADD CONSTRAINT ENG_EQPT_TYPE_IBFK_1
    FOREIGN KEY (ENG_EQPT_TYPE_ID)
    REFERENCES EQPT_TYPE(EQPT_TYPE_ID)

ALTER TABLE EQPT_TYPE
  ADD CONSTRAINT EQPT_TYPE_IBFK_1
    FOREIGN KEY (EQPT_TYPE_ID)
    REFERENCES MAT_TYPE(MAT_TYPE_ID)

ALTER TABLE EXCTV_MIL_ORG_TYPE
  ADD CONSTRAINT EXCTV_MIL_ORG_TYPE_IBFK_1
    FOREIGN KEY (EXCTV_MIL_ORG_TYPE_ID)
    REFERENCES MIL_ORG_TYPE(MIL_ORG_TYPE_ID)

ALTER TABLE FAC
  ADD CONSTRAINT FAC_IBFK_1
    FOREIGN KEY (FAC_ID)
    REFERENCES OBJ_ITEM(OBJ_ITEM_ID)

ALTER TABLE FAC_TYPE
  ADD CONSTRAINT FAC_TYPE_IBFK_1
    FOREIGN KEY (FAC_TYPE_ID)
    REFERENCES OBJ_TYPE(OBJ_TYPE_ID)
-- ==  120 STATEMENTS ============================================
ALTER TABLE GOVEMP_TYPE
  ADD CONSTRAINT GOVEMP_TYPE_IBFK_1
    FOREIGN KEY (GOVT_EMPL_TYPE_OCC)
    REFERENCES SKILL_TYPE(SKILL_TYPE_ID)

ALTER TABLE GOVEMP_TYPE
  ADD CONSTRAINT GOVEMP_TYPE_IBFK_2
    FOREIGN KEY (GOVT_EMPL_TYPE_MAX_GRADE)
    REFERENCES SKILL_TYPE(SKILL_TYPE_ID)

ALTER TABLE GOVEMP_TYPE
  ADD CONSTRAINT GOVEMP_TYPE_IBFK_4
    FOREIGN KEY (PERS_TYPE_ID)
    REFERENCES CIV_PERS_TYPE(PERS_TYPE_ID)

ALTER TABLE GOVEMP_TYPE
  ADD CONSTRAINT GOVEMP_TYPE_IBFK_3
    FOREIGN KEY (GOVT_EMPL_TYPE_MIN_GRADE)
    REFERENCES SKILL_TYPE(SKILL_TYPE_ID)

ALTER TABLE GOVT_ORG_TYPE
  ADD CONSTRAINT GOVT_ORG_TYPE_IBFK_1
    FOREIGN KEY (GOVT_ORG_TYPE_ID)
    REFERENCES ORG_TYPE(ORG_TYPE_ID)

ALTER TABLE LAND_WEAPON_TYPE
  ADD CONSTRAINT LAND_WEAPON_TYPE_IBFK_1
    FOREIGN KEY (LAND_WEAPON_TYPE_ID)
    REFERENCES EQPT_TYPE(EQPT_TYPE_ID)

ALTER TABLE MAT
  ADD CONSTRAINT MAT_IBFK_1
    FOREIGN KEY (MAT_ID)
    REFERENCES OBJ_ITEM(OBJ_ITEM_ID)

ALTER TABLE MAT_TYPE
  ADD CONSTRAINT MAT_TYPE_IBFK_1
    FOREIGN KEY (MAT_TYPE_ID)
    REFERENCES OBJ_TYPE(OBJ_TYPE_ID)

ALTER TABLE MILTRY_PERS_TYPE
  ADD CONSTRAINT MILTRY_PERS_TYPE_IBFK_2
    FOREIGN KEY (MIL_PERS_TYPE_SKILL_LEVEL)
    REFERENCES SKILL_TYPE(SKILL_TYPE_ID)

ALTER TABLE MILTRY_PERS_TYPE
  ADD CONSTRAINT MILTRY_PERS_TYPE_IBFK_5
    FOREIGN KEY (MIL_PERS_TYPE_GRADE)
    REFERENCES SKILL_TYPE(SKILL_TYPE_ID)
-- ==  130 STATEMENTS ============================================
ALTER TABLE MILTRY_PERS_TYPE
  ADD CONSTRAINT MILTRY_PERS_TYPE_IBFK_1
    FOREIGN KEY (MIL_PERS_TYPE_SEC_OCC)
    REFERENCES SKILL_TYPE(SKILL_TYPE_ID)

ALTER TABLE MILTRY_PERS_TYPE
  ADD CONSTRAINT MILTRY_PERS_TYPE_IBFK_6
    FOREIGN KEY (PERS_TYPE_ID)
    REFERENCES PERS_TYPE(PERS_TYPE_ID)

ALTER TABLE MILTRY_PERS_TYPE
  ADD CONSTRAINT MILTRY_PERS_TYPE_IBFK_3
    FOREIGN KEY (MIL_PERS_TYPE_PRI_OCC)
    REFERENCES SKILL_TYPE(SKILL_TYPE_ID)

ALTER TABLE MILTRY_PERS_TYPE
  ADD CONSTRAINT MILTRY_PERS_TYPE_IBFK_4
    FOREIGN KEY (MIL_PERS_TYPE_RANK)
    REFERENCES SKILL_TYPE(SKILL_TYPE_ID)

ALTER TABLE MIL_ORG_TYPE
  ADD CONSTRAINT MIL_ORG_TYPE_IBFK_1
    FOREIGN KEY (MIL_ORG_TYPE_ID)
    REFERENCES GOVT_ORG_TYPE(GOVT_ORG_TYPE_ID)

ALTER TABLE MIL_POST_TYPE
  ADD CONSTRAINT MIL_POST_TYPE_IBFK_1
    FOREIGN KEY (MIL_POST_TYPE_ID)
    REFERENCES MIL_ORG_TYPE(MIL_ORG_TYPE_ID)

ALTER TABLE MIL_POST_TYPE_SKILL_TYPE_DET
  ADD CONSTRAINT SKILL_TYPE_DET_IBFK_1
    FOREIGN KEY (SKILL_TYPE_ID)
    REFERENCES SKILL_TYPE(SKILL_TYPE_ID)

ALTER TABLE MIL_POST_TYPE_SKILL_TYPE_DET
  ADD CONSTRAINT SKILL_TYPE_DET_IBFK_2
    FOREIGN KEY (MIL_POST_TYPE_ID)
    REFERENCES MIL_POST_TYPE(MIL_POST_TYPE_ID)

ALTER TABLE MISC_EQPT_TYPE
  ADD CONSTRAINT MISC_EQPT_TYPE_IBFK_1
    FOREIGN KEY (MISC_EQPT_TYPE_ID)
    REFERENCES EQPT_TYPE(EQPT_TYPE_ID)

ALTER TABLE NBC_EQPT_TYPE
  ADD CONSTRAINT NBC_EQPT_TYPE_IBFK_1
    FOREIGN KEY (NBC_EQPT_TYPE_ID)
    REFERENCES EQPT_TYPE(EQPT_TYPE_ID)
-- ==  140 STATEMENTS ============================================
ALTER TABLE OBJECT_ITEM_ALIAS
  ADD CONSTRAINT OBJECT_ITEM_ALIAS_IBFK_2
    FOREIGN KEY (ALIAS_ID)
    REFERENCES ALIAS(ALIAS_ID)

ALTER TABLE OBJECT_ITEM_ALIAS
  ADD CONSTRAINT OBJECT_ITEM_ALIAS_IBFK_1
    FOREIGN KEY (OBJ_ITEM_ID)
    REFERENCES OBJ_ITEM(OBJ_ITEM_ID)

ALTER TABLE OBJECT_TYPE_ALIAS
  ADD CONSTRAINT OBJECT_TYPE_ALIAS_IBFK_2
    FOREIGN KEY (ALIAS_ID)
    REFERENCES ALIAS(ALIAS_ID)

ALTER TABLE OBJECT_TYPE_ALIAS
  ADD CONSTRAINT OBJECT_TYPE_ALIAS_IBFK_1
    FOREIGN KEY (OBJ_TYPE_ID)
    REFERENCES OBJ_TYPE(OBJ_TYPE_ID)

ALTER TABLE OBJT_ESTAB_OBJT_DET_ROLE_ASSOC
  ADD CONSTRAINT DET_ROLE_ASSOC_IBFK_2
    FOREIGN KEY (ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX,OBJ_TYPE_ESTAB_OBJT_DET_IX)
    REFERENCES OBJ_TYPE_ESTAB_OBJT_DET(ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX,OBJ_TYPE_ESTAB_OBJT_DET_IX)

ALTER TABLE OBJT_ESTAB_OBJT_DET_ROLE_ASSOC
  ADD CONSTRAINT DET_ROLE_ASSOC_IBFK_1
    FOREIGN KEY (SKILL_TYPE_ID)
    REFERENCES SKILL_TYPE(SKILL_TYPE_ID)

ALTER TABLE OBJ_ITEM_ADDR
  ADD CONSTRAINT OBJ_ITEM_ADDR_IBFK_2
    FOREIGN KEY (OBJ_ITEM_ID)
    REFERENCES OBJ_ITEM(OBJ_ITEM_ID)

ALTER TABLE OBJ_ITEM_ADDR
  ADD CONSTRAINT OBJ_ITEM_ADDR_IBFK_1
    FOREIGN KEY (ADDR_ID)
    REFERENCES ADDR(ADDR_ID)

ALTER TABLE OBJ_ITEM_AFFL
  ADD CONSTRAINT OBJ_ITEM_AFFL_IBFK_1
    FOREIGN KEY (OBJ_ITEM_ID)
    REFERENCES OBJ_ITEM(OBJ_ITEM_ID)

ALTER TABLE OBJ_ITEM_AFFL
  ADD CONSTRAINT OBJ_ITEM_AFFL_IBFK_2
    FOREIGN KEY (AFFL_ID)
    REFERENCES AFFL(AFFL_ID)
-- ==  150 STATEMENTS ============================================
ALTER TABLE OBJ_ITEM_ASSOC
  ADD CONSTRAINT OBJ_ITEM_ASSOC_IBFK_1
    FOREIGN KEY (SUBJ_OBJ_ITEM_ID)
    REFERENCES OBJ_ITEM(OBJ_ITEM_ID)

ALTER TABLE OBJ_ITEM_ASSOC
  ADD CONSTRAINT OBJ_ITEM_ASSOC_IBFK_2
    FOREIGN KEY (OBJ_OBJ_ITEM_ID)
    REFERENCES OBJ_ITEM(OBJ_ITEM_ID)

ALTER TABLE OBJ_ITEM_ASSOC_ROLE_ASSOC
  ADD CONSTRAINT ROLE_ASSOC_IBFK_2
    FOREIGN KEY (SUBJ_OBJ_ITEM_ID,OBJ_OBJ_ITEM_ID,OBJ_ITEM_ASSOC_IX)
    REFERENCES OBJ_ITEM_ASSOC(SUBJ_OBJ_ITEM_ID,OBJ_OBJ_ITEM_ID,OBJ_ITEM_ASSOC_IX)

ALTER TABLE OBJ_ITEM_ASSOC_ROLE_ASSOC
  ADD CONSTRAINT ROLE_ASSOC_IBFK_1
    FOREIGN KEY (ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX,OBJ_TYPE_ESTAB_OBJT_DET_IX)
    REFERENCES OBJ_TYPE_ESTAB_OBJT_DET(ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX,OBJ_TYPE_ESTAB_OBJT_DET_IX)

ALTER TABLE OBJ_ITEM_OBJ_TYPE_ESTAB
  ADD CONSTRAINT OBJ_ITEM_OBJ_TYPE_ESTAB_IBFK_2
    FOREIGN KEY (ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX)
    REFERENCES OBJ_TYPE_ESTAB(ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX)

ALTER TABLE OBJ_ITEM_OBJ_TYPE_ESTAB
  ADD CONSTRAINT OBJ_ITEM_OBJ_TYPE_ESTAB_IBFK_1
    FOREIGN KEY (OBJ_ITEM_ID)
    REFERENCES OBJ_ITEM(OBJ_ITEM_ID)

ALTER TABLE OBJ_ITEM_TYPE
  ADD CONSTRAINT OBJ_ITEM_TYPE_IBFK_2
    FOREIGN KEY (OBJ_TYPE_ID)
    REFERENCES OBJ_TYPE(OBJ_TYPE_ID)

ALTER TABLE OBJ_ITEM_TYPE
  ADD CONSTRAINT OBJ_ITEM_TYPE_IBFK_1
    FOREIGN KEY (OBJ_ITEM_ID)
    REFERENCES OBJ_ITEM(OBJ_ITEM_ID)

ALTER TABLE OBJ_TYPE_AFFL
  ADD CONSTRAINT OBJ_TYPE_AFFL_IBFK_1
    FOREIGN KEY (OBJ_TYPE_ID)
    REFERENCES OBJ_TYPE(OBJ_TYPE_ID)

ALTER TABLE OBJ_TYPE_AFFL
  ADD CONSTRAINT OBJ_TYPE_AFFL_IBFK_2
    FOREIGN KEY (AFFL_ID)
    REFERENCES AFFL(AFFL_ID)
-- ==  160 STATEMENTS ============================================
ALTER TABLE OBJ_TYPE_ESTAB
  ADD CONSTRAINT OBJ_TYPE_ESTAB_IBFK_1
    FOREIGN KEY (ESTABD_OBJ_TYPE_ID)
    REFERENCES OBJ_TYPE(OBJ_TYPE_ID)

ALTER TABLE OBJ_TYPE_ESTAB_OBJT_DET
  ADD CONSTRAINT OBJ_TYPE_ESTAB_OBJT_DET_IBFK_1
    FOREIGN KEY (DET_OBJ_TYPE_ID,DET_OBJ_TYPE_ESTAB_IX)
    REFERENCES OBJ_TYPE_ESTAB(ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX)

ALTER TABLE OBJ_TYPE_ESTAB_OBJT_DET
  ADD CONSTRAINT OBJ_TYPE_ESTAB_OBJT_DET_IBFK_2
    FOREIGN KEY (ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX)
    REFERENCES OBJ_TYPE_ESTAB(ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX)

ALTER TABLE ORG
  ADD CONSTRAINT ORG_IBFK_1
    FOREIGN KEY (ORG_ID)
    REFERENCES OBJ_ITEM(OBJ_ITEM_ID)

ALTER TABLE ORG_ORG_TYPE_ESTAB
  ADD CONSTRAINT ORG_ORG_TYPE_ESTAB_IBFK_1
    FOREIGN KEY (OBJ_ITEM_ID,ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX,ORG_ORG_TYPE_ESTAB_IX)
    REFERENCES OBJ_ITEM_OBJ_TYPE_ESTAB(OBJ_ITEM_ID,ESTABD_OBJ_TYPE_ID,OBJ_TYPE_ESTAB_IX,OBJ_ITEM_OBJ_TYPE_ESTAB_IX)

ALTER TABLE ORG_TYPE
  ADD CONSTRAINT ORG_TYPE_IBFK_1
    FOREIGN KEY (ORG_TYPE_ID)
    REFERENCES OBJ_TYPE(OBJ_TYPE_ID)

ALTER TABLE PERS_TYPE
  ADD CONSTRAINT PERS_TYPE_IBFK_1
    FOREIGN KEY (PERS_TYPE_ID)
    REFERENCES OBJ_TYPE(OBJ_TYPE_ID)

ALTER TABLE PHYSCL_ADDR
  ADD CONSTRAINT PHYSCL_ADDR_IBFK_1
    FOREIGN KEY (ADDR_ID)
    REFERENCES ADDR(ADDR_ID)

ALTER TABLE RAILCAR_TYPE
  ADD CONSTRAINT RAILCAR_TYPE_IBFK_1
    FOREIGN KEY (RAILCAR_TYPE_ID)
    REFERENCES EQPT_TYPE(EQPT_TYPE_ID)

ALTER TABLE SKILL_TYPE
  ADD CONSTRAINT SKILL_TYPE_IBFK_1
    FOREIGN KEY (SKILL_TYPE_ATT_ID)
    REFERENCES SKILL_TYPE_ATTRIBUTE(SKILL_TYPE_ATT_ID)
-- ==  170 STATEMENTS ============================================
ALTER TABLE UNIT
  ADD CONSTRAINT UNIT_IBFK_1
    FOREIGN KEY (UNIT_ID)
    REFERENCES ORG(ORG_ID)

ALTER TABLE UNIT_TYPE
  ADD CONSTRAINT UNIT_TYPE_IBFK_2
    FOREIGN KEY (SUPPORTED_MIL_ORG_TYPE_ID)
    REFERENCES MIL_ORG_TYPE(MIL_ORG_TYPE_ID)

ALTER TABLE UNIT_TYPE
  ADD CONSTRAINT UNIT_TYPE_IBFK_3
    FOREIGN KEY (PRINCIPAL_EQPT_TYPE_ID)
    REFERENCES EQPT_TYPE(EQPT_TYPE_ID)

ALTER TABLE UNIT_TYPE
  ADD CONSTRAINT UNIT_TYPE_IBFK_1
    FOREIGN KEY (UNIT_TYPE_ID)
    REFERENCES MIL_ORG_TYPE(MIL_ORG_TYPE_ID)

ALTER TABLE VEHICLE_TYPE
  ADD CONSTRAINT VEHICLE_TYPE_IBFK_1
    FOREIGN KEY (VEHICLE_TYPE_ID)
    REFERENCES EQPT_TYPE(EQPT_TYPE_ID)

ALTER TABLE VESSEL_TYPE
  ADD CONSTRAINT VESSEL_TYPE_IBFK_1
    FOREIGN KEY (VESSEL_TYPE_ID)
    REFERENCES EQPT_TYPE(EQPT_TYPE_ID)

-- ** Run the statements for this schema **
;


-- Uncomment the following line for use of the logging facility
--spool off

commit;
-- ==  167 STATEMENTS ============================================
