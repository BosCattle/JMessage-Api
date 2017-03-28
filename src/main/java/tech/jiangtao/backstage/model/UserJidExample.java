package tech.jiangtao.backstage.model;

import java.util.ArrayList;
import java.util.List;

public class UserJidExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserJidExample() {
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

        public Criteria andJidIdIsNull() {
            addCriterion("jid_id is null");
            return (Criteria) this;
        }

        public Criteria andJidIdIsNotNull() {
            addCriterion("jid_id is not null");
            return (Criteria) this;
        }

        public Criteria andJidIdEqualTo(Long value) {
            addCriterion("jid_id =", value, "jidId");
            return (Criteria) this;
        }

        public Criteria andJidIdNotEqualTo(Long value) {
            addCriterion("jid_id <>", value, "jidId");
            return (Criteria) this;
        }

        public Criteria andJidIdGreaterThan(Long value) {
            addCriterion("jid_id >", value, "jidId");
            return (Criteria) this;
        }

        public Criteria andJidIdGreaterThanOrEqualTo(Long value) {
            addCriterion("jid_id >=", value, "jidId");
            return (Criteria) this;
        }

        public Criteria andJidIdLessThan(Long value) {
            addCriterion("jid_id <", value, "jidId");
            return (Criteria) this;
        }

        public Criteria andJidIdLessThanOrEqualTo(Long value) {
            addCriterion("jid_id <=", value, "jidId");
            return (Criteria) this;
        }

        public Criteria andJidIdIn(List<Long> values) {
            addCriterion("jid_id in", values, "jidId");
            return (Criteria) this;
        }

        public Criteria andJidIdNotIn(List<Long> values) {
            addCriterion("jid_id not in", values, "jidId");
            return (Criteria) this;
        }

        public Criteria andJidIdBetween(Long value1, Long value2) {
            addCriterion("jid_id between", value1, value2, "jidId");
            return (Criteria) this;
        }

        public Criteria andJidIdNotBetween(Long value1, Long value2) {
            addCriterion("jid_id not between", value1, value2, "jidId");
            return (Criteria) this;
        }

        public Criteria andJidShaIsNull() {
            addCriterion("jid_sha is null");
            return (Criteria) this;
        }

        public Criteria andJidShaIsNotNull() {
            addCriterion("jid_sha is not null");
            return (Criteria) this;
        }

        public Criteria andJidShaEqualTo(String value) {
            addCriterion("jid_sha =", value, "jidSha");
            return (Criteria) this;
        }

        public Criteria andJidShaNotEqualTo(String value) {
            addCriterion("jid_sha <>", value, "jidSha");
            return (Criteria) this;
        }

        public Criteria andJidShaGreaterThan(String value) {
            addCriterion("jid_sha >", value, "jidSha");
            return (Criteria) this;
        }

        public Criteria andJidShaGreaterThanOrEqualTo(String value) {
            addCriterion("jid_sha >=", value, "jidSha");
            return (Criteria) this;
        }

        public Criteria andJidShaLessThan(String value) {
            addCriterion("jid_sha <", value, "jidSha");
            return (Criteria) this;
        }

        public Criteria andJidShaLessThanOrEqualTo(String value) {
            addCriterion("jid_sha <=", value, "jidSha");
            return (Criteria) this;
        }

        public Criteria andJidShaLike(String value) {
            addCriterion("jid_sha like", value, "jidSha");
            return (Criteria) this;
        }

        public Criteria andJidShaNotLike(String value) {
            addCriterion("jid_sha not like", value, "jidSha");
            return (Criteria) this;
        }

        public Criteria andJidShaIn(List<String> values) {
            addCriterion("jid_sha in", values, "jidSha");
            return (Criteria) this;
        }

        public Criteria andJidShaNotIn(List<String> values) {
            addCriterion("jid_sha not in", values, "jidSha");
            return (Criteria) this;
        }

        public Criteria andJidShaBetween(String value1, String value2) {
            addCriterion("jid_sha between", value1, value2, "jidSha");
            return (Criteria) this;
        }

        public Criteria andJidShaNotBetween(String value1, String value2) {
            addCriterion("jid_sha not between", value1, value2, "jidSha");
            return (Criteria) this;
        }

        public Criteria andJidIsNull() {
            addCriterion("jid is null");
            return (Criteria) this;
        }

        public Criteria andJidIsNotNull() {
            addCriterion("jid is not null");
            return (Criteria) this;
        }

        public Criteria andJidEqualTo(String value) {
            addCriterion("jid =", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotEqualTo(String value) {
            addCriterion("jid <>", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidGreaterThan(String value) {
            addCriterion("jid >", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidGreaterThanOrEqualTo(String value) {
            addCriterion("jid >=", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLessThan(String value) {
            addCriterion("jid <", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLessThanOrEqualTo(String value) {
            addCriterion("jid <=", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidLike(String value) {
            addCriterion("jid like", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotLike(String value) {
            addCriterion("jid not like", value, "jid");
            return (Criteria) this;
        }

        public Criteria andJidIn(List<String> values) {
            addCriterion("jid in", values, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotIn(List<String> values) {
            addCriterion("jid not in", values, "jid");
            return (Criteria) this;
        }

        public Criteria andJidBetween(String value1, String value2) {
            addCriterion("jid between", value1, value2, "jid");
            return (Criteria) this;
        }

        public Criteria andJidNotBetween(String value1, String value2) {
            addCriterion("jid not between", value1, value2, "jid");
            return (Criteria) this;
        }

        public Criteria andHistoryEnabledIsNull() {
            addCriterion("history_enabled is null");
            return (Criteria) this;
        }

        public Criteria andHistoryEnabledIsNotNull() {
            addCriterion("history_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andHistoryEnabledEqualTo(Integer value) {
            addCriterion("history_enabled =", value, "historyEnabled");
            return (Criteria) this;
        }

        public Criteria andHistoryEnabledNotEqualTo(Integer value) {
            addCriterion("history_enabled <>", value, "historyEnabled");
            return (Criteria) this;
        }

        public Criteria andHistoryEnabledGreaterThan(Integer value) {
            addCriterion("history_enabled >", value, "historyEnabled");
            return (Criteria) this;
        }

        public Criteria andHistoryEnabledGreaterThanOrEqualTo(Integer value) {
            addCriterion("history_enabled >=", value, "historyEnabled");
            return (Criteria) this;
        }

        public Criteria andHistoryEnabledLessThan(Integer value) {
            addCriterion("history_enabled <", value, "historyEnabled");
            return (Criteria) this;
        }

        public Criteria andHistoryEnabledLessThanOrEqualTo(Integer value) {
            addCriterion("history_enabled <=", value, "historyEnabled");
            return (Criteria) this;
        }

        public Criteria andHistoryEnabledIn(List<Integer> values) {
            addCriterion("history_enabled in", values, "historyEnabled");
            return (Criteria) this;
        }

        public Criteria andHistoryEnabledNotIn(List<Integer> values) {
            addCriterion("history_enabled not in", values, "historyEnabled");
            return (Criteria) this;
        }

        public Criteria andHistoryEnabledBetween(Integer value1, Integer value2) {
            addCriterion("history_enabled between", value1, value2, "historyEnabled");
            return (Criteria) this;
        }

        public Criteria andHistoryEnabledNotBetween(Integer value1, Integer value2) {
            addCriterion("history_enabled not between", value1, value2, "historyEnabled");
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