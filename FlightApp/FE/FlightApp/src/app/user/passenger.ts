export class Passenger{
    passportNo: string;
    userId: number;
    name: string;
    address: string;
    idCardNo:string;
    idCardType:string;
    gender: string;
    age: number;
    dob: Date;
    phone: number;
    email:string;
    id: number;
    userType: string;
    constructor(){
      this.passportNo = undefined;
      this.address =undefined;
      this.age = undefined;
      this.dob = undefined;
      this.email = undefined;
      this.idCardNo = undefined;
      this.name = undefined;
      this.phone = undefined;
      this.gender = 'Male';
      this.userType = 'secondary';
    }
}