import Application from 'ember-company-admin/app';
import config from 'ember-company-admin/config/environment';
import { setApplication } from '@ember/test-helpers';
import { start } from 'ember-qunit';

setApplication(Application.create(config.APP));

start();
