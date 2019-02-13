import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DailougeComponent } from './dailouge.component';

describe('DailougeComponent', () => {
  let component: DailougeComponent;
  let fixture: ComponentFixture<DailougeComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DailougeComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DailougeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
