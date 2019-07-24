import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientMidSectionComponent } from './client-mid-section.component';

describe('ClientMidSectionComponent', () => {
  let component: ClientMidSectionComponent;
  let fixture: ComponentFixture<ClientMidSectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientMidSectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientMidSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
