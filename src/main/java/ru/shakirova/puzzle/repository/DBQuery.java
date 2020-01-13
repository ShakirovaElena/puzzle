package ru.shakirova.puzzle.repository;

interface DBQuery {
    public static final String SELECT_QUESTION_ALL = "select * from question order by difficultyLevel, text ";
    public static final String SELECT_QUESTION_BY_DIF_LEV = "select * from question where difficulty_level_id = ?1 ";
    public static final String SELECT_ANSWERS_BY_QUESTION = "select * from answer where  question_id = ?1 ";
    public static final String SELECT_STATISTICS_BY_QUESTION = "select * from statistics where question_id = ?1 ";
    public static final String SELECT_STATISTICS_BY_USER = "select * from statistics where user_id = ?1 ";
    public static final String SELECT_ALL_USERS = "select * from users order by login ";
    public static final String SELECT_ALL_USERS_BY_QUESTION = "select t1.* from users t1 "+ 
                                                                " inner join statistics t2 on t1.id = t2.user_id "+
                                                                " where t2.question_id = ?1 ";

}
