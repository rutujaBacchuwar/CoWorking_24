import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ClientImageComponent } from './client-image.component';

describe('ClientImageComponent', () => {
  let component: ClientImageComponent;
  let fixture: ComponentFixture<ClientImageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ClientImageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ClientImageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
