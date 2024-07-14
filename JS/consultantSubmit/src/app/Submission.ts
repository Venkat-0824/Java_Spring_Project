export class Submission {
    id:number;
    date: string;
    consultantName: string;
    technology: string;
    leads: string;
    salesPerson: string;
    vendorName: string;
    rate: number;
  
    constructor(id:number,date: string, consultantName: string, technology: string, leads: string, salerPerson: string, vendorName: string, rate: number) {
        this.id=id;
      this.date = date;
      this.consultantName = consultantName;
      this.technology = technology;
      this.leads = leads;
      this.salesPerson = salerPerson;
      this.vendorName = vendorName;
      this.rate = rate;
    }
  }

