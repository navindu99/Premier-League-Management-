import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableWinsComponent } from './table-wins.component';

describe('TableWinsComponent', () => {
  let component: TableWinsComponent;
  let fixture: ComponentFixture<TableWinsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableWinsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TableWinsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
