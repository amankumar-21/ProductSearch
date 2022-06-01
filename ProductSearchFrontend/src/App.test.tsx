import React from 'react';
import { fireEvent, render, screen } from '@testing-library/react';
import App from './App';

test('It should render input element',() =>{
  render(<App />);
  const inputElement = screen.getByPlaceholderText('Search Product Id Or Product Name');
  expect(inputElement).toBeInTheDocument();
});

test('It should be able to type into input',() =>{
  render(<App />);
  const inputElement = screen.getByPlaceholderText('Search Product Id Or Product Name');
  fireEvent.change(inputElement, { target: { value: "iphone" } })
  expect((inputElement as HTMLInputElement).value).toBe("iphone");
});
