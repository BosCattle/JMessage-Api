package tech.jiangtao.backstage.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShortNewsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShortNewsExample() {
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

        public Criteria andSnidIsNull() {
            addCriterion("snid is null");
            return (Criteria) this;
        }

        public Criteria andSnidIsNotNull() {
            addCriterion("snid is not null");
            return (Criteria) this;
        }

        public Criteria andSnidEqualTo(Long value) {
            addCriterion("snid =", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidNotEqualTo(Long value) {
            addCriterion("snid <>", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidGreaterThan(Long value) {
            addCriterion("snid >", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidGreaterThanOrEqualTo(Long value) {
            addCriterion("snid >=", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidLessThan(Long value) {
            addCriterion("snid <", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidLessThanOrEqualTo(Long value) {
            addCriterion("snid <=", value, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidIn(List<Long> values) {
            addCriterion("snid in", values, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidNotIn(List<Long> values) {
            addCriterion("snid not in", values, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidBetween(Long value1, Long value2) {
            addCriterion("snid between", value1, value2, "snid");
            return (Criteria) this;
        }

        public Criteria andSnidNotBetween(Long value1, Long value2) {
            addCriterion("snid not between", value1, value2, "snid");
            return (Criteria) this;
        }

        public Criteria andPublishingTimeIsNull() {
            addCriterion("publishing_time is null");
            return (Criteria) this;
        }

        public Criteria andPublishingTimeIsNotNull() {
            addCriterion("publishing_time is not null");
            return (Criteria) this;
        }

        public Criteria andPublishingTimeEqualTo(Date value) {
            addCriterion("publishing_time =", value, "publishingTime");
            return (Criteria) this;
        }

        public Criteria andPublishingTimeNotEqualTo(Date value) {
            addCriterion("publishing_time <>", value, "publishingTime");
            return (Criteria) this;
        }

        public Criteria andPublishingTimeGreaterThan(Date value) {
            addCriterion("publishing_time >", value, "publishingTime");
            return (Criteria) this;
        }

        public Criteria andPublishingTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("publishing_time >=", value, "publishingTime");
            return (Criteria) this;
        }

        public Criteria andPublishingTimeLessThan(Date value) {
            addCriterion("publishing_time <", value, "publishingTime");
            return (Criteria) this;
        }

        public Criteria andPublishingTimeLessThanOrEqualTo(Date value) {
            addCriterion("publishing_time <=", value, "publishingTime");
            return (Criteria) this;
        }

        public Criteria andPublishingTimeIn(List<Date> values) {
            addCriterion("publishing_time in", values, "publishingTime");
            return (Criteria) this;
        }

        public Criteria andPublishingTimeNotIn(List<Date> values) {
            addCriterion("publishing_time not in", values, "publishingTime");
            return (Criteria) this;
        }

        public Criteria andPublishingTimeBetween(Date value1, Date value2) {
            addCriterion("publishing_time between", value1, value2, "publishingTime");
            return (Criteria) this;
        }

        public Criteria andPublishingTimeNotBetween(Date value1, Date value2) {
            addCriterion("publishing_time not between", value1, value2, "publishingTime");
            return (Criteria) this;
        }

        public Criteria andNewsTypeIsNull() {
            addCriterion("news_type is null");
            return (Criteria) this;
        }

        public Criteria andNewsTypeIsNotNull() {
            addCriterion("news_type is not null");
            return (Criteria) this;
        }

        public Criteria andNewsTypeEqualTo(String value) {
            addCriterion("news_type =", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeNotEqualTo(String value) {
            addCriterion("news_type <>", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeGreaterThan(String value) {
            addCriterion("news_type >", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeGreaterThanOrEqualTo(String value) {
            addCriterion("news_type >=", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeLessThan(String value) {
            addCriterion("news_type <", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeLessThanOrEqualTo(String value) {
            addCriterion("news_type <=", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeLike(String value) {
            addCriterion("news_type like", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeNotLike(String value) {
            addCriterion("news_type not like", value, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeIn(List<String> values) {
            addCriterion("news_type in", values, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeNotIn(List<String> values) {
            addCriterion("news_type not in", values, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeBetween(String value1, String value2) {
            addCriterion("news_type between", value1, value2, "newsType");
            return (Criteria) this;
        }

        public Criteria andNewsTypeNotBetween(String value1, String value2) {
            addCriterion("news_type not between", value1, value2, "newsType");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNull() {
            addCriterion("author is null");
            return (Criteria) this;
        }

        public Criteria andAuthorIsNotNull() {
            addCriterion("author is not null");
            return (Criteria) this;
        }

        public Criteria andAuthorEqualTo(String value) {
            addCriterion("author =", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotEqualTo(String value) {
            addCriterion("author <>", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThan(String value) {
            addCriterion("author >", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("author >=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThan(String value) {
            addCriterion("author <", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLessThanOrEqualTo(String value) {
            addCriterion("author <=", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorLike(String value) {
            addCriterion("author like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotLike(String value) {
            addCriterion("author not like", value, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorIn(List<String> values) {
            addCriterion("author in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotIn(List<String> values) {
            addCriterion("author not in", values, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorBetween(String value1, String value2) {
            addCriterion("author between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andAuthorNotBetween(String value1, String value2) {
            addCriterion("author not between", value1, value2, "author");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNull() {
            addCriterion("subject is null");
            return (Criteria) this;
        }

        public Criteria andSubjectIsNotNull() {
            addCriterion("subject is not null");
            return (Criteria) this;
        }

        public Criteria andSubjectEqualTo(String value) {
            addCriterion("subject =", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotEqualTo(String value) {
            addCriterion("subject <>", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThan(String value) {
            addCriterion("subject >", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectGreaterThanOrEqualTo(String value) {
            addCriterion("subject >=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThan(String value) {
            addCriterion("subject <", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLessThanOrEqualTo(String value) {
            addCriterion("subject <=", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectLike(String value) {
            addCriterion("subject like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotLike(String value) {
            addCriterion("subject not like", value, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectIn(List<String> values) {
            addCriterion("subject in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotIn(List<String> values) {
            addCriterion("subject not in", values, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectBetween(String value1, String value2) {
            addCriterion("subject between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andSubjectNotBetween(String value1, String value2) {
            addCriterion("subject not between", value1, value2, "subject");
            return (Criteria) this;
        }

        public Criteria andBodyIsNull() {
            addCriterion("body is null");
            return (Criteria) this;
        }

        public Criteria andBodyIsNotNull() {
            addCriterion("body is not null");
            return (Criteria) this;
        }

        public Criteria andBodyEqualTo(String value) {
            addCriterion("body =", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotEqualTo(String value) {
            addCriterion("body <>", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThan(String value) {
            addCriterion("body >", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyGreaterThanOrEqualTo(String value) {
            addCriterion("body >=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThan(String value) {
            addCriterion("body <", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLessThanOrEqualTo(String value) {
            addCriterion("body <=", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyLike(String value) {
            addCriterion("body like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotLike(String value) {
            addCriterion("body not like", value, "body");
            return (Criteria) this;
        }

        public Criteria andBodyIn(List<String> values) {
            addCriterion("body in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotIn(List<String> values) {
            addCriterion("body not in", values, "body");
            return (Criteria) this;
        }

        public Criteria andBodyBetween(String value1, String value2) {
            addCriterion("body between", value1, value2, "body");
            return (Criteria) this;
        }

        public Criteria andBodyNotBetween(String value1, String value2) {
            addCriterion("body not between", value1, value2, "body");
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