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

export class LoginCreds{
    public userId :number;
    public loginPassword :string;
}

export class AddTransaction{
    public fromAccount :number;
	public toAccount :number;
    public amount :number;
	public transactionPassword :string;
    public transactionMode :string;
    public remarks  :string;
}

export class Beneficiary{
    public beneficiaryAccountnumber :number;
    public userAccountnumber :number;
    public beneficiaryName :string;
    public beneficiaryNickname :string;
}

export class UserAccountDetails{
    public userId:string;
    public accountNumber:String;
    public balance:number;
}

export class NetbankingRegistration{
    
    public accountNumber :number;
    public loginPassword :string;
    public transactionPassword  :string;
}

export class TransactionDetails{
    
    public amount :number;
    public payeeAccountNumber :number;
    public payerAccountNumber :number;
    public transactionMode  :string;
    public transactionDate  :Date;
}

export class ChangePassword{
    
    public userId :number;
    public loginPassword  :string;
}

export class NewPassword{
    
    public userId :string;
    public loginPassword  :string;
    public transactionPassword :string;
}