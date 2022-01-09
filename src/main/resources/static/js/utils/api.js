const requestPostApi = async (url, data) => {
  console.log('111');
  await $.ajax({
    method: "POST",
    url: url, 
    contentType:"application/json; charset=utf-8",
    dataType:"json",
    data: JSON.stringify(data),
    success: await function(result) {
      return result;
    },
    error: await function(result, aa) {
      console.log('여기탐');
      console.log('result', result);
      console.log('aa', aa);
      return result;
    }
  })
}