import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildregComponent } from './childreg.component';

describe('ChildregComponent', () => {
  let component: ChildregComponent;
  let fixture: ComponentFixture<ChildregComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChildregComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChildregComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
