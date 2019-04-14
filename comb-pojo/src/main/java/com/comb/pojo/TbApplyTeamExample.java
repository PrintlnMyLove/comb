package com.comb.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbApplyTeamExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbApplyTeamExample() {
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

        public Criteria andTeamIdIsNull() {
            addCriterion("team_id is null");
            return (Criteria) this;
        }

        public Criteria andTeamIdIsNotNull() {
            addCriterion("team_id is not null");
            return (Criteria) this;
        }

        public Criteria andTeamIdEqualTo(Long value) {
            addCriterion("team_id =", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotEqualTo(Long value) {
            addCriterion("team_id <>", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThan(Long value) {
            addCriterion("team_id >", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdGreaterThanOrEqualTo(Long value) {
            addCriterion("team_id >=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThan(Long value) {
            addCriterion("team_id <", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdLessThanOrEqualTo(Long value) {
            addCriterion("team_id <=", value, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdIn(List<Long> values) {
            addCriterion("team_id in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotIn(List<Long> values) {
            addCriterion("team_id not in", values, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdBetween(Long value1, Long value2) {
            addCriterion("team_id between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamIdNotBetween(Long value1, Long value2) {
            addCriterion("team_id not between", value1, value2, "teamId");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNull() {
            addCriterion("team_name is null");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNotNull() {
            addCriterion("team_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNameEqualTo(String value) {
            addCriterion("team_name =", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotEqualTo(String value) {
            addCriterion("team_name <>", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThan(String value) {
            addCriterion("team_name >", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("team_name >=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThan(String value) {
            addCriterion("team_name <", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThanOrEqualTo(String value) {
            addCriterion("team_name <=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLike(String value) {
            addCriterion("team_name like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotLike(String value) {
            addCriterion("team_name not like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameIn(List<String> values) {
            addCriterion("team_name in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotIn(List<String> values) {
            addCriterion("team_name not in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameBetween(String value1, String value2) {
            addCriterion("team_name between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotBetween(String value1, String value2) {
            addCriterion("team_name not between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamMemberIsNull() {
            addCriterion("team_member is null");
            return (Criteria) this;
        }

        public Criteria andTeamMemberIsNotNull() {
            addCriterion("team_member is not null");
            return (Criteria) this;
        }

        public Criteria andTeamMemberEqualTo(String value) {
            addCriterion("team_member =", value, "teamMember");
            return (Criteria) this;
        }

        public Criteria andTeamMemberNotEqualTo(String value) {
            addCriterion("team_member <>", value, "teamMember");
            return (Criteria) this;
        }

        public Criteria andTeamMemberGreaterThan(String value) {
            addCriterion("team_member >", value, "teamMember");
            return (Criteria) this;
        }

        public Criteria andTeamMemberGreaterThanOrEqualTo(String value) {
            addCriterion("team_member >=", value, "teamMember");
            return (Criteria) this;
        }

        public Criteria andTeamMemberLessThan(String value) {
            addCriterion("team_member <", value, "teamMember");
            return (Criteria) this;
        }

        public Criteria andTeamMemberLessThanOrEqualTo(String value) {
            addCriterion("team_member <=", value, "teamMember");
            return (Criteria) this;
        }

        public Criteria andTeamMemberLike(String value) {
            addCriterion("team_member like", value, "teamMember");
            return (Criteria) this;
        }

        public Criteria andTeamMemberNotLike(String value) {
            addCriterion("team_member not like", value, "teamMember");
            return (Criteria) this;
        }

        public Criteria andTeamMemberIn(List<String> values) {
            addCriterion("team_member in", values, "teamMember");
            return (Criteria) this;
        }

        public Criteria andTeamMemberNotIn(List<String> values) {
            addCriterion("team_member not in", values, "teamMember");
            return (Criteria) this;
        }

        public Criteria andTeamMemberBetween(String value1, String value2) {
            addCriterion("team_member between", value1, value2, "teamMember");
            return (Criteria) this;
        }

        public Criteria andTeamMemberNotBetween(String value1, String value2) {
            addCriterion("team_member not between", value1, value2, "teamMember");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIsNull() {
            addCriterion("team_leader is null");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIsNotNull() {
            addCriterion("team_leader is not null");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderEqualTo(String value) {
            addCriterion("team_leader =", value, "teamLeader");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderNotEqualTo(String value) {
            addCriterion("team_leader <>", value, "teamLeader");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderGreaterThan(String value) {
            addCriterion("team_leader >", value, "teamLeader");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderGreaterThanOrEqualTo(String value) {
            addCriterion("team_leader >=", value, "teamLeader");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderLessThan(String value) {
            addCriterion("team_leader <", value, "teamLeader");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderLessThanOrEqualTo(String value) {
            addCriterion("team_leader <=", value, "teamLeader");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderLike(String value) {
            addCriterion("team_leader like", value, "teamLeader");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderNotLike(String value) {
            addCriterion("team_leader not like", value, "teamLeader");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderIn(List<String> values) {
            addCriterion("team_leader in", values, "teamLeader");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderNotIn(List<String> values) {
            addCriterion("team_leader not in", values, "teamLeader");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderBetween(String value1, String value2) {
            addCriterion("team_leader between", value1, value2, "teamLeader");
            return (Criteria) this;
        }

        public Criteria andTeamLeaderNotBetween(String value1, String value2) {
            addCriterion("team_leader not between", value1, value2, "teamLeader");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneIsNull() {
            addCriterion("team_phone is null");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneIsNotNull() {
            addCriterion("team_phone is not null");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneEqualTo(String value) {
            addCriterion("team_phone =", value, "teamPhone");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneNotEqualTo(String value) {
            addCriterion("team_phone <>", value, "teamPhone");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneGreaterThan(String value) {
            addCriterion("team_phone >", value, "teamPhone");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("team_phone >=", value, "teamPhone");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneLessThan(String value) {
            addCriterion("team_phone <", value, "teamPhone");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneLessThanOrEqualTo(String value) {
            addCriterion("team_phone <=", value, "teamPhone");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneLike(String value) {
            addCriterion("team_phone like", value, "teamPhone");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneNotLike(String value) {
            addCriterion("team_phone not like", value, "teamPhone");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneIn(List<String> values) {
            addCriterion("team_phone in", values, "teamPhone");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneNotIn(List<String> values) {
            addCriterion("team_phone not in", values, "teamPhone");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneBetween(String value1, String value2) {
            addCriterion("team_phone between", value1, value2, "teamPhone");
            return (Criteria) this;
        }

        public Criteria andTeamPhoneNotBetween(String value1, String value2) {
            addCriterion("team_phone not between", value1, value2, "teamPhone");
            return (Criteria) this;
        }

        public Criteria andFilesizeIsNull() {
            addCriterion("FileSize is null");
            return (Criteria) this;
        }

        public Criteria andFilesizeIsNotNull() {
            addCriterion("FileSize is not null");
            return (Criteria) this;
        }

        public Criteria andFilesizeEqualTo(Long value) {
            addCriterion("FileSize =", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeNotEqualTo(Long value) {
            addCriterion("FileSize <>", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeGreaterThan(Long value) {
            addCriterion("FileSize >", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeGreaterThanOrEqualTo(Long value) {
            addCriterion("FileSize >=", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeLessThan(Long value) {
            addCriterion("FileSize <", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeLessThanOrEqualTo(Long value) {
            addCriterion("FileSize <=", value, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeIn(List<Long> values) {
            addCriterion("FileSize in", values, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeNotIn(List<Long> values) {
            addCriterion("FileSize not in", values, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeBetween(Long value1, Long value2) {
            addCriterion("FileSize between", value1, value2, "filesize");
            return (Criteria) this;
        }

        public Criteria andFilesizeNotBetween(Long value1, Long value2) {
            addCriterion("FileSize not between", value1, value2, "filesize");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
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