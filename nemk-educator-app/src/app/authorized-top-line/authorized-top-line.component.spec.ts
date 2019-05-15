import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorizedTopLineComponent } from './authorized-top-line.component';

describe('AuthorizedTopLineComponent', () => {
  let component: AuthorizedTopLineComponent;
  let fixture: ComponentFixture<AuthorizedTopLineComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorizedTopLineComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorizedTopLineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
