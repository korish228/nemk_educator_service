import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BasicTopLineComponent } from './basic-top-line.component';

describe('BasicTopLineComponent', () => {
  let component: BasicTopLineComponent;
  let fixture: ComponentFixture<BasicTopLineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BasicTopLineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BasicTopLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
