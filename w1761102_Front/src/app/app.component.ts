import { Component } from '@angular/core';
import { FormBuilder } from '@angular/forms';
export interface PeriodicElement {
 }

const ELEMENT_DATA: PeriodicElement[] = [
];

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'PremierLeague';
  displayedColumns: string[] = [''];
  dataSource = ELEMENT_DATA;

  constructor (private formBuider:FormBuilder){}
    matchform = this.formBuider.group({
      year:[''],
      month:[''],
      date:['']
    })
}
