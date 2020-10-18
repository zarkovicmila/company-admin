import DS from 'ember-data';
import { validator, buildValidations } from 'ember-cp-validations';

const Validations = buildValidations({
  name: validator('presence', true),
  surname: validator('presence', true),
  email: validator('presence', true),
  salary: validator('number', {
    allowString: true,
    gt: 0
  })
});

export default  DS.Model.extend(Validations, {

    name: DS.attr('string'),
    surname: DS.attr('string'),
    address: DS.attr('string'),
    email: DS.attr('string'),
    salary: DS.attr('string'),
    company_name: DS.attr('string'),
    company_id: DS.attr('string'),
    company: DS.belongsTo('company')
    
 });
