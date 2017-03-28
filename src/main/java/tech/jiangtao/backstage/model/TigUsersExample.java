package tech.jiangtao.backstage.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TigUsersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TigUsersExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(Long value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(Long value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(Long value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(Long value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(Long value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(Long value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<Long> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<Long> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(Long value1, Long value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(Long value1, Long value2) {
            addCriterion("uid not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdIsNull() {
            addCriterion("sha1_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdIsNotNull() {
            addCriterion("sha1_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdEqualTo(String value) {
            addCriterion("sha1_user_id =", value, "sha1UserId");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdNotEqualTo(String value) {
            addCriterion("sha1_user_id <>", value, "sha1UserId");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdGreaterThan(String value) {
            addCriterion("sha1_user_id >", value, "sha1UserId");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdGreaterThanOrEqualTo(String value) {
            addCriterion("sha1_user_id >=", value, "sha1UserId");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdLessThan(String value) {
            addCriterion("sha1_user_id <", value, "sha1UserId");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdLessThanOrEqualTo(String value) {
            addCriterion("sha1_user_id <=", value, "sha1UserId");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdLike(String value) {
            addCriterion("sha1_user_id like", value, "sha1UserId");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdNotLike(String value) {
            addCriterion("sha1_user_id not like", value, "sha1UserId");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdIn(List<String> values) {
            addCriterion("sha1_user_id in", values, "sha1UserId");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdNotIn(List<String> values) {
            addCriterion("sha1_user_id not in", values, "sha1UserId");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdBetween(String value1, String value2) {
            addCriterion("sha1_user_id between", value1, value2, "sha1UserId");
            return (Criteria) this;
        }

        public Criteria andSha1UserIdNotBetween(String value1, String value2) {
            addCriterion("sha1_user_id not between", value1, value2, "sha1UserId");
            return (Criteria) this;
        }

        public Criteria andUserPwIsNull() {
            addCriterion("user_pw is null");
            return (Criteria) this;
        }

        public Criteria andUserPwIsNotNull() {
            addCriterion("user_pw is not null");
            return (Criteria) this;
        }

        public Criteria andUserPwEqualTo(String value) {
            addCriterion("user_pw =", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwNotEqualTo(String value) {
            addCriterion("user_pw <>", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwGreaterThan(String value) {
            addCriterion("user_pw >", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwGreaterThanOrEqualTo(String value) {
            addCriterion("user_pw >=", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwLessThan(String value) {
            addCriterion("user_pw <", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwLessThanOrEqualTo(String value) {
            addCriterion("user_pw <=", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwLike(String value) {
            addCriterion("user_pw like", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwNotLike(String value) {
            addCriterion("user_pw not like", value, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwIn(List<String> values) {
            addCriterion("user_pw in", values, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwNotIn(List<String> values) {
            addCriterion("user_pw not in", values, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwBetween(String value1, String value2) {
            addCriterion("user_pw between", value1, value2, "userPw");
            return (Criteria) this;
        }

        public Criteria andUserPwNotBetween(String value1, String value2) {
            addCriterion("user_pw not between", value1, value2, "userPw");
            return (Criteria) this;
        }

        public Criteria andAccCreateTimeIsNull() {
            addCriterion("acc_create_time is null");
            return (Criteria) this;
        }

        public Criteria andAccCreateTimeIsNotNull() {
            addCriterion("acc_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andAccCreateTimeEqualTo(Date value) {
            addCriterion("acc_create_time =", value, "accCreateTime");
            return (Criteria) this;
        }

        public Criteria andAccCreateTimeNotEqualTo(Date value) {
            addCriterion("acc_create_time <>", value, "accCreateTime");
            return (Criteria) this;
        }

        public Criteria andAccCreateTimeGreaterThan(Date value) {
            addCriterion("acc_create_time >", value, "accCreateTime");
            return (Criteria) this;
        }

        public Criteria andAccCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("acc_create_time >=", value, "accCreateTime");
            return (Criteria) this;
        }

        public Criteria andAccCreateTimeLessThan(Date value) {
            addCriterion("acc_create_time <", value, "accCreateTime");
            return (Criteria) this;
        }

        public Criteria andAccCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("acc_create_time <=", value, "accCreateTime");
            return (Criteria) this;
        }

        public Criteria andAccCreateTimeIn(List<Date> values) {
            addCriterion("acc_create_time in", values, "accCreateTime");
            return (Criteria) this;
        }

        public Criteria andAccCreateTimeNotIn(List<Date> values) {
            addCriterion("acc_create_time not in", values, "accCreateTime");
            return (Criteria) this;
        }

        public Criteria andAccCreateTimeBetween(Date value1, Date value2) {
            addCriterion("acc_create_time between", value1, value2, "accCreateTime");
            return (Criteria) this;
        }

        public Criteria andAccCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("acc_create_time not between", value1, value2, "accCreateTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginIsNull() {
            addCriterion("last_login is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIsNotNull() {
            addCriterion("last_login is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginEqualTo(Date value) {
            addCriterion("last_login =", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotEqualTo(Date value) {
            addCriterion("last_login <>", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginGreaterThan(Date value) {
            addCriterion("last_login >", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginGreaterThanOrEqualTo(Date value) {
            addCriterion("last_login >=", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginLessThan(Date value) {
            addCriterion("last_login <", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginLessThanOrEqualTo(Date value) {
            addCriterion("last_login <=", value, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginIn(List<Date> values) {
            addCriterion("last_login in", values, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotIn(List<Date> values) {
            addCriterion("last_login not in", values, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginBetween(Date value1, Date value2) {
            addCriterion("last_login between", value1, value2, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLoginNotBetween(Date value1, Date value2) {
            addCriterion("last_login not between", value1, value2, "lastLogin");
            return (Criteria) this;
        }

        public Criteria andLastLogoutIsNull() {
            addCriterion("last_logout is null");
            return (Criteria) this;
        }

        public Criteria andLastLogoutIsNotNull() {
            addCriterion("last_logout is not null");
            return (Criteria) this;
        }

        public Criteria andLastLogoutEqualTo(Date value) {
            addCriterion("last_logout =", value, "lastLogout");
            return (Criteria) this;
        }

        public Criteria andLastLogoutNotEqualTo(Date value) {
            addCriterion("last_logout <>", value, "lastLogout");
            return (Criteria) this;
        }

        public Criteria andLastLogoutGreaterThan(Date value) {
            addCriterion("last_logout >", value, "lastLogout");
            return (Criteria) this;
        }

        public Criteria andLastLogoutGreaterThanOrEqualTo(Date value) {
            addCriterion("last_logout >=", value, "lastLogout");
            return (Criteria) this;
        }

        public Criteria andLastLogoutLessThan(Date value) {
            addCriterion("last_logout <", value, "lastLogout");
            return (Criteria) this;
        }

        public Criteria andLastLogoutLessThanOrEqualTo(Date value) {
            addCriterion("last_logout <=", value, "lastLogout");
            return (Criteria) this;
        }

        public Criteria andLastLogoutIn(List<Date> values) {
            addCriterion("last_logout in", values, "lastLogout");
            return (Criteria) this;
        }

        public Criteria andLastLogoutNotIn(List<Date> values) {
            addCriterion("last_logout not in", values, "lastLogout");
            return (Criteria) this;
        }

        public Criteria andLastLogoutBetween(Date value1, Date value2) {
            addCriterion("last_logout between", value1, value2, "lastLogout");
            return (Criteria) this;
        }

        public Criteria andLastLogoutNotBetween(Date value1, Date value2) {
            addCriterion("last_logout not between", value1, value2, "lastLogout");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIsNull() {
            addCriterion("online_status is null");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIsNotNull() {
            addCriterion("online_status is not null");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusEqualTo(Integer value) {
            addCriterion("online_status =", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotEqualTo(Integer value) {
            addCriterion("online_status <>", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusGreaterThan(Integer value) {
            addCriterion("online_status >", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("online_status >=", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLessThan(Integer value) {
            addCriterion("online_status <", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusLessThanOrEqualTo(Integer value) {
            addCriterion("online_status <=", value, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusIn(List<Integer> values) {
            addCriterion("online_status in", values, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotIn(List<Integer> values) {
            addCriterion("online_status not in", values, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusBetween(Integer value1, Integer value2) {
            addCriterion("online_status between", value1, value2, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andOnlineStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("online_status not between", value1, value2, "onlineStatus");
            return (Criteria) this;
        }

        public Criteria andFailedLoginsIsNull() {
            addCriterion("failed_logins is null");
            return (Criteria) this;
        }

        public Criteria andFailedLoginsIsNotNull() {
            addCriterion("failed_logins is not null");
            return (Criteria) this;
        }

        public Criteria andFailedLoginsEqualTo(Integer value) {
            addCriterion("failed_logins =", value, "failedLogins");
            return (Criteria) this;
        }

        public Criteria andFailedLoginsNotEqualTo(Integer value) {
            addCriterion("failed_logins <>", value, "failedLogins");
            return (Criteria) this;
        }

        public Criteria andFailedLoginsGreaterThan(Integer value) {
            addCriterion("failed_logins >", value, "failedLogins");
            return (Criteria) this;
        }

        public Criteria andFailedLoginsGreaterThanOrEqualTo(Integer value) {
            addCriterion("failed_logins >=", value, "failedLogins");
            return (Criteria) this;
        }

        public Criteria andFailedLoginsLessThan(Integer value) {
            addCriterion("failed_logins <", value, "failedLogins");
            return (Criteria) this;
        }

        public Criteria andFailedLoginsLessThanOrEqualTo(Integer value) {
            addCriterion("failed_logins <=", value, "failedLogins");
            return (Criteria) this;
        }

        public Criteria andFailedLoginsIn(List<Integer> values) {
            addCriterion("failed_logins in", values, "failedLogins");
            return (Criteria) this;
        }

        public Criteria andFailedLoginsNotIn(List<Integer> values) {
            addCriterion("failed_logins not in", values, "failedLogins");
            return (Criteria) this;
        }

        public Criteria andFailedLoginsBetween(Integer value1, Integer value2) {
            addCriterion("failed_logins between", value1, value2, "failedLogins");
            return (Criteria) this;
        }

        public Criteria andFailedLoginsNotBetween(Integer value1, Integer value2) {
            addCriterion("failed_logins not between", value1, value2, "failedLogins");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNull() {
            addCriterion("account_status is null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIsNotNull() {
            addCriterion("account_status is not null");
            return (Criteria) this;
        }

        public Criteria andAccountStatusEqualTo(Integer value) {
            addCriterion("account_status =", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotEqualTo(Integer value) {
            addCriterion("account_status <>", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThan(Integer value) {
            addCriterion("account_status >", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("account_status >=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThan(Integer value) {
            addCriterion("account_status <", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusLessThanOrEqualTo(Integer value) {
            addCriterion("account_status <=", value, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusIn(List<Integer> values) {
            addCriterion("account_status in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotIn(List<Integer> values) {
            addCriterion("account_status not in", values, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusBetween(Integer value1, Integer value2) {
            addCriterion("account_status between", value1, value2, "accountStatus");
            return (Criteria) this;
        }

        public Criteria andAccountStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("account_status not between", value1, value2, "accountStatus");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}