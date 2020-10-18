import { helper } from '@ember/component/helper';

export default helper(function indexCount(params) {
  let number = parseFloat(params);
  return number + 1;
});
