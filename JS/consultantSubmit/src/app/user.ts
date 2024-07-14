export class User {
  id:number;
    firstName: string;
    lastName:string;
    email: string;
    password: string;
    role:string;
    leadId:number;

    // Add any other properties you need for your model
  
    constructor(id:number,firstName: string,lastName: string, email: string, password: string,role:string,leadId:number) {
      this.id=id;
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.password= password;
      this.role=role;
      this.leadId=leadId;
    }
  }
  
