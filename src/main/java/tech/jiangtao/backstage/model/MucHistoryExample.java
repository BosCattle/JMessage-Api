package tech.jiangtao.backstage.model;

import java.util.ArrayList;
import java.util.List;

public class MucHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MucHistoryExample() {
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

        public Criteria andRoomNameIsNull() {
            addCriterion("room_name is null");
            return (Criteria) this;
        }

        public Criteria andRoomNameIsNotNull() {
            addCriterion("room_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoomNameEqualTo(String value) {
            addCriterion("room_name =", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotEqualTo(String value) {
            addCriterion("room_name <>", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThan(String value) {
            addCriterion("room_name >", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameGreaterThanOrEqualTo(String value) {
            addCriterion("room_name >=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThan(String value) {
            addCriterion("room_name <", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLessThanOrEqualTo(String value) {
            addCriterion("room_name <=", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameLike(String value) {
            addCriterion("room_name like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotLike(String value) {
            addCriterion("room_name not like", value, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameIn(List<String> values) {
            addCriterion("room_name in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotIn(List<String> values) {
            addCriterion("room_name not in", values, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameBetween(String value1, String value2) {
            addCriterion("room_name between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andRoomNameNotBetween(String value1, String value2) {
            addCriterion("room_name not between", value1, value2, "roomName");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNull() {
            addCriterion("event_type is null");
            return (Criteria) this;
        }

        public Criteria andEventTypeIsNotNull() {
            addCriterion("event_type is not null");
            return (Criteria) this;
        }

        public Criteria andEventTypeEqualTo(Integer value) {
            addCriterion("event_type =", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotEqualTo(Integer value) {
            addCriterion("event_type <>", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThan(Integer value) {
            addCriterion("event_type >", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("event_type >=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThan(Integer value) {
            addCriterion("event_type <", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeLessThanOrEqualTo(Integer value) {
            addCriterion("event_type <=", value, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeIn(List<Integer> values) {
            addCriterion("event_type in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotIn(List<Integer> values) {
            addCriterion("event_type not in", values, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeBetween(Integer value1, Integer value2) {
            addCriterion("event_type between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andEventTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("event_type not between", value1, value2, "eventType");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNull() {
            addCriterion("timestamp is null");
            return (Criteria) this;
        }

        public Criteria andTimestampIsNotNull() {
            addCriterion("timestamp is not null");
            return (Criteria) this;
        }

        public Criteria andTimestampEqualTo(Long value) {
            addCriterion("timestamp =", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotEqualTo(Long value) {
            addCriterion("timestamp <>", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThan(Long value) {
            addCriterion("timestamp >", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampGreaterThanOrEqualTo(Long value) {
            addCriterion("timestamp >=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThan(Long value) {
            addCriterion("timestamp <", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampLessThanOrEqualTo(Long value) {
            addCriterion("timestamp <=", value, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampIn(List<Long> values) {
            addCriterion("timestamp in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotIn(List<Long> values) {
            addCriterion("timestamp not in", values, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampBetween(Long value1, Long value2) {
            addCriterion("timestamp between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andTimestampNotBetween(Long value1, Long value2) {
            addCriterion("timestamp not between", value1, value2, "timestamp");
            return (Criteria) this;
        }

        public Criteria andSenderJidIsNull() {
            addCriterion("sender_jid is null");
            return (Criteria) this;
        }

        public Criteria andSenderJidIsNotNull() {
            addCriterion("sender_jid is not null");
            return (Criteria) this;
        }

        public Criteria andSenderJidEqualTo(String value) {
            addCriterion("sender_jid =", value, "senderJid");
            return (Criteria) this;
        }

        public Criteria andSenderJidNotEqualTo(String value) {
            addCriterion("sender_jid <>", value, "senderJid");
            return (Criteria) this;
        }

        public Criteria andSenderJidGreaterThan(String value) {
            addCriterion("sender_jid >", value, "senderJid");
            return (Criteria) this;
        }

        public Criteria andSenderJidGreaterThanOrEqualTo(String value) {
            addCriterion("sender_jid >=", value, "senderJid");
            return (Criteria) this;
        }

        public Criteria andSenderJidLessThan(String value) {
            addCriterion("sender_jid <", value, "senderJid");
            return (Criteria) this;
        }

        public Criteria andSenderJidLessThanOrEqualTo(String value) {
            addCriterion("sender_jid <=", value, "senderJid");
            return (Criteria) this;
        }

        public Criteria andSenderJidLike(String value) {
            addCriterion("sender_jid like", value, "senderJid");
            return (Criteria) this;
        }

        public Criteria andSenderJidNotLike(String value) {
            addCriterion("sender_jid not like", value, "senderJid");
            return (Criteria) this;
        }

        public Criteria andSenderJidIn(List<String> values) {
            addCriterion("sender_jid in", values, "senderJid");
            return (Criteria) this;
        }

        public Criteria andSenderJidNotIn(List<String> values) {
            addCriterion("sender_jid not in", values, "senderJid");
            return (Criteria) this;
        }

        public Criteria andSenderJidBetween(String value1, String value2) {
            addCriterion("sender_jid between", value1, value2, "senderJid");
            return (Criteria) this;
        }

        public Criteria andSenderJidNotBetween(String value1, String value2) {
            addCriterion("sender_jid not between", value1, value2, "senderJid");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameIsNull() {
            addCriterion("sender_nickname is null");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameIsNotNull() {
            addCriterion("sender_nickname is not null");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameEqualTo(String value) {
            addCriterion("sender_nickname =", value, "senderNickname");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameNotEqualTo(String value) {
            addCriterion("sender_nickname <>", value, "senderNickname");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameGreaterThan(String value) {
            addCriterion("sender_nickname >", value, "senderNickname");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameGreaterThanOrEqualTo(String value) {
            addCriterion("sender_nickname >=", value, "senderNickname");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameLessThan(String value) {
            addCriterion("sender_nickname <", value, "senderNickname");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameLessThanOrEqualTo(String value) {
            addCriterion("sender_nickname <=", value, "senderNickname");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameLike(String value) {
            addCriterion("sender_nickname like", value, "senderNickname");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameNotLike(String value) {
            addCriterion("sender_nickname not like", value, "senderNickname");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameIn(List<String> values) {
            addCriterion("sender_nickname in", values, "senderNickname");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameNotIn(List<String> values) {
            addCriterion("sender_nickname not in", values, "senderNickname");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameBetween(String value1, String value2) {
            addCriterion("sender_nickname between", value1, value2, "senderNickname");
            return (Criteria) this;
        }

        public Criteria andSenderNicknameNotBetween(String value1, String value2) {
            addCriterion("sender_nickname not between", value1, value2, "senderNickname");
            return (Criteria) this;
        }

        public Criteria andPublicEventIsNull() {
            addCriterion("public_event is null");
            return (Criteria) this;
        }

        public Criteria andPublicEventIsNotNull() {
            addCriterion("public_event is not null");
            return (Criteria) this;
        }

        public Criteria andPublicEventEqualTo(Boolean value) {
            addCriterion("public_event =", value, "publicEvent");
            return (Criteria) this;
        }

        public Criteria andPublicEventNotEqualTo(Boolean value) {
            addCriterion("public_event <>", value, "publicEvent");
            return (Criteria) this;
        }

        public Criteria andPublicEventGreaterThan(Boolean value) {
            addCriterion("public_event >", value, "publicEvent");
            return (Criteria) this;
        }

        public Criteria andPublicEventGreaterThanOrEqualTo(Boolean value) {
            addCriterion("public_event >=", value, "publicEvent");
            return (Criteria) this;
        }

        public Criteria andPublicEventLessThan(Boolean value) {
            addCriterion("public_event <", value, "publicEvent");
            return (Criteria) this;
        }

        public Criteria andPublicEventLessThanOrEqualTo(Boolean value) {
            addCriterion("public_event <=", value, "publicEvent");
            return (Criteria) this;
        }

        public Criteria andPublicEventIn(List<Boolean> values) {
            addCriterion("public_event in", values, "publicEvent");
            return (Criteria) this;
        }

        public Criteria andPublicEventNotIn(List<Boolean> values) {
            addCriterion("public_event not in", values, "publicEvent");
            return (Criteria) this;
        }

        public Criteria andPublicEventBetween(Boolean value1, Boolean value2) {
            addCriterion("public_event between", value1, value2, "publicEvent");
            return (Criteria) this;
        }

        public Criteria andPublicEventNotBetween(Boolean value1, Boolean value2) {
            addCriterion("public_event not between", value1, value2, "publicEvent");
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