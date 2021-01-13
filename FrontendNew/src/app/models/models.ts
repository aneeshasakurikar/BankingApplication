export class Models {
}

export class UserDetails{
    
    public title :string;
    public firstName :string;
    public middleName :string;
    public lastName  :string;
    public fatherName  :string;
    public mobileNumber :string;
    public emailId :string;
    public aadharNumber :string;
    public dateOfBirth :Date;
    public addressLine1 :string;
    public addressLine2 :string;
    public landMark  :string;
    public state :string;
    public city :string;
    public pincode :number;
    public occupationType :string;
    public sourceOfIncome :string;
    public annualIncome :string;
}

export class UserApprovalDetails{
    public aadharNumber :string;
    public status :boolean;
    public adminRemarks :string;
}