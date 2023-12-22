import { Component } from '@angular/core';
import { ConsignmentService } from '../consignment.service';
import { ConsignmentModel } from '../consignmentmodel';

@Component({
  selector: 'app-consignment',
  templateUrl: './consignment.component.html',
  styleUrls: ['./consignment.component.css']
})
export class ConsignmentComponent {

  consignment: ConsignmentModel[] = [];

  constructor(private consignmentservice:ConsignmentService) { }

  ngOnInit() {  
    this.consignmentservice.getConsignment().subscribe(data => {
        this.consignment = data;
    });
  }
}
