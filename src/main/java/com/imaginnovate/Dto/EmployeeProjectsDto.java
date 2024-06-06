package com.imaginnovate.Dto;

public class EmployeeProjectsDto {
    
       private int id;

       private int employee;

       private int project;

       private Boolean canApproveTimesheets;

        public EmployeeProjectsDto() {
        }

        public EmployeeProjectsDto(int id, int employee, int project, Boolean canApproveTimesheets) {
            this.id = id;
            this.employee = employee;
            this.project = project;
            this.canApproveTimesheets = canApproveTimesheets;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEmployee() {
            return employee;
        }

        public void setEmployee(int employee) {
            this.employee = employee;
        }

        public int getProject() {
            return project;
        }

        public void setProject(int project) {
            this.project = project;
        }

        public Boolean getCanApproveTimesheets() {
            return canApproveTimesheets;
        }

        public void setCanApproveTimesheets(Boolean canApproveTimesheets) {
            this.canApproveTimesheets = canApproveTimesheets;
        }

        

}
