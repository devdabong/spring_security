CREATE TABLE `tb_user` (
  `USER_ID` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '회원 아이디',
  `USER_NM` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '이름',
  `USER_PWD` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '비밀번호',
  `ADMIN_YN` enum('Y','N') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'N' COMMENT '관리자 여부',
  `PHONE` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '전화번호',
  `FAIL_CNT` tinyint NOT NULL DEFAULT '0' COMMENT '로그인실패 횟수',
  `LAST_LOGIN_DATE` datetime DEFAULT NULL COMMENT '최근 로그인 일시',
  `DEL_YN` enum('Y','N') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'N' COMMENT '탈퇴여부',
  `CRE_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '생성일시',
  `PWD_MOD_DATE` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '비밀번호 변경일시',
  PRIMARY KEY (`USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci
