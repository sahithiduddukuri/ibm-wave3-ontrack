import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ChildregcompComponent } from './childregcomp.component';

describe('ChildregcompComponent', () => {
  let component: ChildregcompComponent;
  let fixture: ComponentFixture<ChildregcompComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ChildregcompComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ChildregcompComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
