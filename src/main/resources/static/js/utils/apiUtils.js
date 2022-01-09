
const requestGetApi = async (url, data) => {
  return await $.ajax({
    method: "GET",
    url: url,
    data: data,
    success: (response) => response,
    error: (response) => response
  })
}

const requestPostApi = async (url, data) => {
  return await $.ajax({
    method: "POST",
    url: url, 
    contentType:"application/json; charset=utf-8",
    dataType:"json",
    data: JSON.stringify(data),
    success: (response) => response,
    error: (response) => response
  })
}