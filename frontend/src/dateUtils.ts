export function formatDate(dateArray: number[]): string {
    const [year, month, day, hours, minutes] = dateArray;
    const formattedDate = `${day < 10 ? '0' + day : day}/${month < 10 ? '0' + month : month}/${year} - ${hours < 10 ? '0' + hours : hours}:${minutes < 10 ? '0' + minutes : minutes}`;
    return formattedDate;
  }

  export function parseDate(dateString: string, timeString: string): Date {
    const [day, month, year] = dateString.split('/').map(Number);
    const [hours, minutes, seconds] = timeString.split(':').map(Number);
  
    if (
      isNaN(day) || isNaN(month) || isNaN(year) ||
      isNaN(hours) || isNaN(minutes) || isNaN(seconds)
    ) {
      throw new Error('Data ou horário inválido');
    }
  
    const timezoneOffset = new Date().getTimezoneOffset();
    const adjustedMinutes = minutes - timezoneOffset;
  
    const date = new Date(year, month - 1, day, hours, adjustedMinutes, seconds);
  
    if (isNaN(date.getTime())) {
      throw new Error('Data ou horário inválido');
    }
  
    return date;
  }

/*
export function parseDate(dateTimeString: string): Date {
  const [dateString, timeString] = dateTimeString.split(' ');

  const [day, month, year] = dateString.split('/').map(Number);
  const [hours, minutes, seconds] = timeString.split(':').map(Number);

  if (
    isNaN(day) || isNaN(month) || isNaN(year) ||
    isNaN(hours) || isNaN(minutes) || isNaN(seconds)
  ) {
    throw new Error('Data ou horário inválido');
  }

  // Note que a contagem dos meses no objeto Date começa a partir de 0, então subtraímos 1 do valor do mês.
  const date = new Date(year, month - 1, day, hours, minutes, seconds);

  // Verifica se a data é válida
  if (isNaN(date.getTime())) {
    throw new Error('Data ou horário inválido');
  }

  const formattedDate = date.toISOString().slice(0, 19);
  return new Date(formattedDate);
}
*/
export function formatTime(timeArray: number[]): string {
  const [hours, minutes] = timeArray;
  const formattedTime = `${hours < 10 ? '0' + hours : hours}:${minutes < 10 ? '0' + minutes : minutes}`;
  return formattedTime;
}